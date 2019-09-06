# Micronaut whit GraalVM native application
> Microservice using micronaut framework and running it as a native application into a Docker container with GraalVM

## Prerequisites
#### SDKman
SDKMAN! is a tool for managing parallel versions of multiple Software Development Kits on most Unix based systems.
It provides a convenient Command Line Interface (CLI) and API for installing, switching, removing and listing Candidates.

[Follow the instructions to install it](https://sdkman.io/install)


#### Gradle
Install it running the following commands:
```bash
sdk ls gradle
sdk i gradle 5.4.1
sdk u gradle 5.4.1
```


#### Docker CE
Docker provides a way to run applications securely isolated in a container, packaged with all its dependencies and libraries.

[Follow the instructions to install it](https://docs.docker.com/install/)




## Installation

#### Micronaut
`Natively Cloud Native`

[Micronaut](https://micronaut.io/) is a modern, JVM-based, full stack microservices framework designed for building modular,
easily testable microservice applications. 

Install micronaut CLI running the following commands:
```bash
sdk ls micronaut
sdk i micronaut 1.2.0
sdk u micronaut 1.2.0
```


#### GraalVM
`High-performance polyglot VM`

[GraalVM](https://www.graalvm.org/) is a standalone Java Development Kit to execute Java or JVM-based languages 
(e.g. Scala, Kotlin), dynamic languages (e.g. JavaScript, R, Ruby, R, Python), LLVM-based languages (e.g. C and C++) in 
one shared runtime, and supports Linux and macOS platforms on x86 64-bit systems. It is available as Community Edition (CE) 
and Enterprise Edition (EE). GraalVM Community Edition is based on the OpenJDK 8. GraalVM Enterprise Edition is developed 
on top of the Java SE 1.8.0_212.

In your terminal run the following commands:
```bash
sdk ls java
sdk i java 19.0.0-grl
sdk u java 19.0.0-grl
gu install native-image
```
gu = Graal Update, the last command is necesary for support native image with graal VM



## Usage
Official documentation:
https://docs.micronaut.io/latest/guide/index.html#introduction

1.- **Creating the project**
Go to your prefer path and run:

- Using the micronaut CLI
```bash
mn create-app micronaut-graalvm-greetService --features graal-native-image

```

- Using this git repository
```
git clone https://github.com/cjeronimomx/micronaut-graalvm-greetService.git
``` 

Then move you to micronaut-graalvm-greetService folder (cd micronaut-graalvm-greetService).

2.- **Building and running a Native image**
```bash
gradle assemble
```
- Without Docker
```bash
native-image --no-server -cp build/libs/micronaut-graalvm-greetService-0.1.jar
./micornaut-graalvm-native
```
- With Docker:
```bash
./docker-build.sh
docker run -p 8080:8080 micronaut-graalvm-greetService
```
