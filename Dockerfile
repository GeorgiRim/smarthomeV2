FROM openjdk:8
WORKDIR /usr/smarthome
RUN apt update && apt upgrade
RUN apt install git
RUN git clone https://github.com/GeorgiRim/smarthomeV2.git
RUN ./gradlew
#COMMENT
CMD ["java", "-Xmx512M", "-jar", ".\build\libs\smarthome-0.0.1-SNAPSHOT.jar"]