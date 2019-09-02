FROM oracle/graalvm-ce:1.0.0-rc15 as graalvm
COPY . /home/app/micronaut-graalvm-service
WORKDIR /home/app/micronaut-graalvm-service
RUN native-image --no-server -cp build/libs/micronaut-graalvm-service-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-graalvm-service .
ENTRYPOINT ["./micronaut-graalvm-service"]
