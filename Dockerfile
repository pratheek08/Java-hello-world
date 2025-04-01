FROM openjdk:11

WORKDIR /app

COPY . /app

RUN javac HelloWorld.java

CMD java HelloWorld && tail -f /dev/null
