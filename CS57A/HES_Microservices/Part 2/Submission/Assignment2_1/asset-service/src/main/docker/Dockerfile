FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd && apk add curl
RUN mkdir -p /usr/local/asset-service
ADD @project.build.finalName@.jar /usr/local/asset-service/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh