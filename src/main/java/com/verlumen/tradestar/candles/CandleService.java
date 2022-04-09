package com.verlumen.tradestar.candles;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.verlumen.tradestar.protos.candles.Candle;
import com.verlumen.tradestar.protos.instruments.Instrument;

import java.time.Instant;

public interface CandleService {
    ImmutableSet<Candle> getCandles(Instrument instrument,
                                    Range<Instant> timeRange);
}
