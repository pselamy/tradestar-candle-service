java_binary(
    name = "candle_service",
    srcs = ["CandleService.java"],
    main_class = "com.verlumen.tradestar.candles.CandleService",
    deps = [
        "@maven//:org_springframework_boot_spring_boot",
        "@maven//:org_springframework_boot_spring_boot_autoconfigure",
        "@maven//:org_springframework_boot_spring_boot_starter_web",
        "@maven//:org_springframework_spring_context",
        "@maven//:org_springframework_spring_web",
    ],
)

java_library(
    name = "candle_controller",
    srcs = ["CandleController.java"],
    deps = [
        "@maven//:org_springframework_spring_beans",
        "@maven//:org_springframework_spring_web",
        "@tradestar_protos//:candles_java_proto",
        "@tradestar_protos//:instruments_java_proto",
        "@tradestar_repos//src/main/java/com/verlumen/tradestar/repositories/candles:candle_repository",
        "@tradestar_repos//src/main/java/com/verlumen/tradestar/repositories/instruments:instrument_repository",
    ],
)
