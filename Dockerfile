FROM maven:latest

WORKDIR /app

COPY jenkins/ /app/
RUN ls /app  # Add this line

RUN mvn package

CMD ["java", "-jar", "target/interconversion.jar"]