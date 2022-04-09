package com.verlumen.tradestar.candles;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.verlumen.tradestar.protos.candles.Candle;
import com.verlumen.tradestar.protos.candles.CandleList;
import com.verlumen.tradestar.protos.candles.Granularity;
import com.verlumen.tradestar.protos.instruments.Instrument;
import com.verlumen.tradestar.repositories.candles.CandleRepository;
import com.verlumen.tradestar.repositories.instruments.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class CandleController {
    @Autowired
    CandleRepository candleRepository;

    @Autowired
    InstrumentRepository instrumentRepository;

    @RequestMapping("/candles/{symbol}/{granularity}")
    CandleList candles(@PathVariable String symbol,
                       @PathVariable String granularity,
                       @RequestParam Long startTime,
                       @RequestParam Long endTime) {
        Instrument instrument = instrumentRepository.getInstrument(symbol);
        return candles(instrument, parseGranularity(granularity),
                Instant.ofEpochSecond(startTime), Instant.ofEpochSecond(endTime));
    }

    private CandleList candles(Instrument instrument, Granularity granularity,
                               Instant startTime, Instant endTime) {
        Range<Instant> timeRange = Range.closedOpen(startTime, endTime);
        ImmutableSet<Candle> candles = candleRepository.getCandles(
                instrument, granularity, timeRange);
        return CandleList.newBuilder().addAllCandles(candles).build();
    }

    private Granularity parseGranularity(String granularity) {
        return Granularity.valueOf(granularity);
    }
}