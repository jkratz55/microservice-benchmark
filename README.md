# Microservice Benchmarks

## Motivation

In the modern era of building applications and systems all the hype is around microservices. There are many frameworks focused on building microservices, implemented in many different languages. There are various benchmarks and articles on the web comparing performance, but in many cases the examples are not indicative of real world behavior. After all who builds services with a single endpoint that just returned Hello World, or some arbitrary string over and over. The purpose of this project is to try to emulate so real world logic, without going to deep into the weeds with an elaborate implementation. 

## Sample Application & Testing Methodology

The application used for benchmarking is a example of an aggregate microservice which returns employee information by retrieving data from various other microservices. The sample application simulates making multiple HTTP calls to other services to aggregate the data into a useful response. In order to simulate real world behavior there are delays to simulate waiting on an HTTP response from an external server. For simplicity and repeatable results the delays are fixed, although in real world scenario response times will vary based on many conditions. 

### Implementations

* Kotlin and Spring Boot (Servlet)
* Kotlin and Spring Boot (Reactive)
* Kotlin and Ktor
* GO and GoKit

## Results

