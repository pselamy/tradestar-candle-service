load("@rules_proto_grpc//java:defs.bzl", "java_grpc_library")

java_grpc_library(
    name = "candle_service_grpc",
    protos = ["@tradestar_protos//:candle_service_proto"],
    deps = [
        "@tradestar_protos//:candles_java_proto",
        "@tradestar_protos//:instruments_java_proto",
    ],
)

java_binary(
    name = "candle_server",
    srcs = ["CandleServer.java"],
    main_class = "com.verlumen.tradestar.candles.CandleServer",
    deps = [
        ":candle_service_grpc",
        "@grpc_server_runner//src/main/java/com/github/pselamy/grpc:grpc_server_runner",
        "@grpc_server_runner//src/main/java/com/github/pselamy/grpc:grpc_server_runner_module",
        "@maven//:com_google_inject_guice",
        "@tradestar_protos//:candles_java_proto",
        "@tradestar_protos//:instruments_java_proto",
        "@tradestar_repos//src/main/java/com/verlumen/tradestar/repositories/candles:candle_repository",
    ],
)
