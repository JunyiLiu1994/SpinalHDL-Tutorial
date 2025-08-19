FROM ubuntu:24.04

ARG TARGETARCH

RUN apt-get update
RUN apt-get install -y git
RUN apt-get install -y tar curl openjdk-17-jdk make g++

WORKDIR /opt

RUN if [ "$TARGETARCH" = "amd64" ]; then \
      export OSSCAD_URL="https://github.com/YosysHQ/oss-cad-suite-build/releases/download/2025-08-18/oss-cad-suite-linux-x64-20250818.tgz"; \
    elif [ "$TARGETARCH" = "arm64" ]; then \
      export OSSCAD_URL="https://github.com/YosysHQ/oss-cad-suite-build/releases/download/2025-08-18/oss-cad-suite-linux-arm64-20250818.tgz"; \
    fi && \
    curl -L $OSSCAD_URL -o oss-cad-suite.tgz

RUN tar -xzvf oss-cad-suite.tgz
RUN rm oss-cad-suite.tgz

RUN curl -fL "https://github.com/coursier/launchers/raw/master/cs-x86_64-pc-linux.gz" | gzip -d > cs && \
  chmod +x cs && \
  mkdir -p /opt/bin && \
  mv ./cs /opt/bin/cs

ENV PATH="/opt/bin:/opt/oss-cad-suite/bin:${PATH}"
ENV LANG=en_US.UTF-8 \
    LANGUAGE=en_US:en \
    LC_ALL=en_US.UTF-8

ARG MILL_VERSION="0.11.11"
RUN \
  curl -L -o /opt/bin/mill https://github.com/lihaoyi/mill/releases/download/$MILL_VERSION/$MILL_VERSION && \
  chmod +x /opt/bin/mill && \
  touch build.sc && \
  mill -i resolve _ && \
  rm build.sc

