package com.verlumen.tradestar.candles;

import com.github.pselamy.grpc.GrpcServerRunner;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.multibindings.Multibinder;
import com.verlumen.tradestar.protos.candles.*;
import com.verlumen.tradestar.repositories.candles.CandleRepository;
import com.verlumen.tradestar.repositories.candles.CandleRepositoryModule;
import io.grpc.BindableService;
import io.grpc.stub.StreamObserver;

import java.time.Instant;

import static com.google.common.base.Preconditions.checkArgument;
import static java.time.Instant.ofEpochSecond;

public class CandleServer {
    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws InterruptedException {
        GrpcServerRunner.run(new CandleServerModule());
    }

    private static class CandleServiceImpl extends CandleServiceGrpc.CandleServiceImplBase {
        private final CandleRepository candleRepository;

        @Inject
        CandleServiceImpl(CandleRepository candleRepository) {
            this.candleRepository = candleRepository;
        }

        private static Range<Instant> getTimeRange(GetCandlesRequest req) {
            Instant start = ofEpochSecond(req.getStart().getSeconds());
            Instant end = ofEpochSecond(req.getEnd().getSeconds());
            return Range.closedOpen(start, end);
        }

        @Override
        public void getCandles(GetCandlesRequest req,
                               StreamObserver<GetCandlesResponse> responseObserver) {
            checkArgument(req.hasInstrument());
            checkArgument(!req.getGranularity().equals(Granularity.UNSPECIFIED));
            checkArgument(req.hasStart());
            checkArgument(req.hasEnd());
            ImmutableSet<Candle> candles = candleRepository.getCandles(req.getInstrument(),
                    req.getGranularity(), getTimeRange(req));
            GetCandlesResponse reply =
                    GetCandlesResponse.newBuilder()
                            .addAllCandles(candles)
                            .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
    
    private enum GetCandlesConstraint {}

    private static class CandleServerModule extends AbstractModule {
        @Override
        protected void configure() {
            Multibinder<BindableService> serviceBinder =
                    Multibinder.newSetBinder(binder(), BindableService.class);
            serviceBinder.addBinding().to(CandleServiceImpl.class);

            install(new CandleRepositoryModule());
        }
    }
}
