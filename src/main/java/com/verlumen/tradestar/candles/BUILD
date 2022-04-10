load("@rules_proto_grpc//java:defs.bzl", "java_grpc_library")

java_library(
    name = "candle_controller",
    srcs = ["CandleController.java"],
    deps = [
        "@maven//:org_springframework_spring_beans",
        "@maven//:org_springframework_spring_web",
        "@tradestar_repos//src/main/java/com/verlumen/tradestar/repositories/candles:candle_repository",
        "@tradestar_repos//src/main/java/com/verlumen/tradestar/repositories/instruments:instrument_repository",
    ],
)

java_binary(
    name = "candle_service",
    srcs = ["CandleService.java"],
    main_class = "com.verlumen.tradestar.candles.CandleService",
    runtime_deps = [
        ":candle_controller",
        ":guice_configuration",
    ],
    deps = [
        "@maven//:org_springframework_boot_spring_boot",
        "@maven//:org_springframework_boot_spring_boot_autoconfigure",
        "@maven//:org_springframework_boot_spring_boot_starter_web",
        "@maven//:org_springframework_spring_context",
        "@maven//:org_springframework_spring_web",
    ],
)

java_grpc_library(
    name = "candle_service_grpc",
    protos = ["@tradestar_protos//:candle_service_proto"],
    deps = [
        "@tradestar_protos//:candles_java_proto",
        "@tradestar_protos//:instruments_java_proto",
    ],
)

java_library(
    name = "guice_configuration",
    srcs = ["GuiceConfiguration.java"],
    deps = [
        "@maven//:com_google_inject_guice",
        "@maven//:org_springframework_guice_spring_guice",
        "@maven//:org_springframework_spring_beans",
        "@maven//:org_springframework_spring_context",
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
