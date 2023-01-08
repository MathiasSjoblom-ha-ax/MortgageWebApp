FROM openjdk:18
RUN mkdir /webApp
COPY src/java/com.webapp.MortgageWebApp /webApp
WORKDIR /webApp
CMD MortgageWebApp