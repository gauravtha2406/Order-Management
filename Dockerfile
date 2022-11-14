FROM openjdk:11
ADD target/order-service.jar order-service.jar
EXPOSE 8100
ENTRYPOINT [ "java", "-jar", "order-service.jar" ]
VOLUME /target