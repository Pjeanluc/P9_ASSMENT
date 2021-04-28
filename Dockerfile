FROM openjdk:14
LABEL maintener="jl.protois.perso@gmail.com"
EXPOSE 8083
ARG JAR_FILE=target/P9_ASSMENT-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} assessment.jar
ENTRYPOINT ["java","-jar","/assessment.jar"]