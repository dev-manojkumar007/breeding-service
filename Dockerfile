FROM openjdk:8
EXPOSE 8090
COPY --from=build /target/breeding-service-docker.jar breeding-service-docker.jar
ENTRYPOINT [ "java","-jar","/breeding-service-docker.jar" ]