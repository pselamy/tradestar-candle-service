package com.verlumen.tradestar.candles;

import com.google.common.collect.ImmutableSet;
import com.verlumen.tradestar.protos.candles.Candle;

public interface CandleService {
    ImmutableSet<Candle> getCandles();
}
