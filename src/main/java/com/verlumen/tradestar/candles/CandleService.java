package com.verlumen.tradestar.candles;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.verlumen.tradestar.protos.candles.Candle;

import java.time.Instant;

public interface CandleService {
    ImmutableSet<Candle> getCandles(Range<Instant> timeRange);
}
