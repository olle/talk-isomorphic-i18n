Isomorphic i18n
===============

Hi! internationalization and localization are certainly not the most glamorous
or fun parts of building a web-app. But they are nevertheless very important
for a good user experience.

In this talk I'm going to show how little it actually takes to get an isomorphic
i18n solution going. This means we don't have to leave the server-side behind,
and can instead build great solutions with progressive enhancement.

It's going to be fun!

## Talk

The [Reveal.JS](http://lab.hakim.se/reveal-js) presentation should be no match
to get going, as long as you have [npm and Node.js](http://nodejs.org). Simply
run:

    npm install
    npm start

This will bootstrap all dependencies and just kickstart the whole thing, enjoy!

## Example App - Spring Boot

I've provided a Spring Boot example application, showing a working proof of
concept. Feel free to check out the code under `src/`.

The demo application is built using [Maven](http://maven.apache.org) and
[Java](http://www.oracle.com/technetwork/java/javase/downloads/). You should
be able to compile and run it, with the command below, and then browse
to the host and port number that was printed on the command line.

    mvn spring-boot:run

Good luck!
