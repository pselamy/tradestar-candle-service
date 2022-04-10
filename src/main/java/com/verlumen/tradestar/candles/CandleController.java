package com.verlumen.tradestar.candles;

import com.verlumen.tradestar.repositories.candles.CandleRepository;
import com.verlumen.tradestar.repositories.instruments.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandleController {
    @Autowired
    CandleRepository candleRepository;

    @Autowired
    InstrumentRepository instrumentRepository;
}