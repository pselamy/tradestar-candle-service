workspace(name = "tradestar_candle_service")

load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

git_repository(
    name = "com_google_protobuf",
    commit = "498de9f761bef56a032815ee44b6e6dbe0892cc4",
    remote = "https://github.com/protocolbuffers/protobuf",
    shallow_since = "1580681072 -0800",
)

load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")

protobuf_deps()

git_repository(
    name = "tradestar_protos",
    commit = "c84f83610145251e98a81e3dd1b8a6baffcda649",
    remote = "https://github.com/pselamy/tradestar-protos",
    shallow_since = "1645497038 -0600",
)

git_repository(
    name = "tradestar_repos",
    commit = "c35b91afb3c859fd65189301e99a58edb61cfff6",
    remote = "https://github.com/pselamy/tradestar-repos",
    shallow_since = "1645497038 -0600",
)

git_repository(
    name = "contrib_rules_jvm",
    commit = "f7c08ec6d73ef691b03f843e0c2c3dbe766df584",
    remote = "https://github.com/bazel-contrib/rules_jvm",
    shallow_since = "1642674503 +0000",
)

load("@contrib_rules_jvm//:repositories.bzl", "contrib_rules_jvm_deps")

contrib_rules_jvm_deps()

load("@contrib_rules_jvm//:setup.bzl", "contrib_rules_jvm_setup")

contrib_rules_jvm_setup()

git_repository(
    name = "rules_proto",
    remote = "https://github.com/bazelbuild/rules_proto",
    tag = "rules_proto 4.0.0-3.20.0",
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")
rules_proto_dependencies()
rules_proto_toolchains()

git_repository(
    name = "rules_proto_grpc",
    remote = "https://github.com/rules-proto-grpc/rules_proto_grpc",
    tag = "4.1.1",
)

load("@rules_proto_grpc//:repositories.bzl", "rules_proto_grpc_repos", "rules_proto_grpc_toolchains")

rules_proto_grpc_toolchains()

rules_proto_grpc_repos()

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()

load("@rules_proto_grpc//java:repositories.bzl", rules_proto_grpc_java_repos = "java_repos")

rules_proto_grpc_java_repos()

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@io_grpc_grpc_java//:repositories.bzl", "IO_GRPC_GRPC_JAVA_ARTIFACTS", "IO_GRPC_GRPC_JAVA_OVERRIDE_TARGETS", "grpc_java_repositories")

grpc_java_repositories()

git_repository(
    name = "rules_jvm_external",
    remote = "https://github.com/bazelbuild/rules_jvm_external",
    tag = "4.2",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "com.google.guava:guava:31.0.1-jre",
        "com.google.inject:guice:5.1.0",
        "org.springframework.boot:spring-boot-autoconfigure:2.1.3.RELEASE",
        "org.springframework.boot:spring-boot-starter-web:2.1.3.RELEASE",
        "org.springframework.boot:spring-boot:2.1.3.RELEASE",
        "org.springframework.guice:spring-guice:2.0.0",
        "org.springframework:spring-beans:5.3.18",
        "org.springframework:spring-context:5.1.5.RELEASE",
        "org.springframework:spring-web:5.1.5.RELEASE",
    ] + IO_GRPC_GRPC_JAVA_ARTIFACTS,
    generate_compat_repositories = True,
    override_targets = IO_GRPC_GRPC_JAVA_OVERRIDE_TARGETS,
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)

load("@maven//:compat.bzl", "compat_repositories")

compat_repositories()
