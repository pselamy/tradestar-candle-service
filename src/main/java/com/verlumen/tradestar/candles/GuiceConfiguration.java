package com.verlumen.tradestar.candles;

import com.google.inject.Module;
import com.google.inject.util.Modules;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.guice.annotation.EnableGuiceModules;

@EnableGuiceModules
@Configuration
public class GuiceConfiguration {
    @Bean
    public static Module myModule() {
        return Modules.combine();
    }
}
