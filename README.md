# GithubTrendingLanguages

GithubTrendingLanguages is a basic REST microservice that lists the languages used by the 100 trending public repos on GitHub.

## Prerequisites
Make sure you have installed all of the following prerequisites on your machine:
* Java (version > 8)
* Maven
* Docker (you can run the application without Docker if you have tomcat installed)

## Installation

Use Maven to package the web app into a .war file.

```bash
maven clean package
```

deploy the app on a tomcat server running in a docker container.

```bash
docker build . --tag github-trending-languages
```
starting the docker container.

```bash
docker run -it -p 8081:8080 github-trending-languages
```

## Usage
use this url with method GET
[http://localhost:8081/GithubTrendingLanguages/GitHub100TrendingLanguages](http://localhost:8081/GithubTrendingLanguages/GitHub100TrendingLanguages)