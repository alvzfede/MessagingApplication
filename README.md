# MessagingApplication
Secure messaging application's REST API backend



### Package
```shell
mvn clean package
```

### Run on container
```shell
docker build --tag=message-server:latest .
docker run -p8887:8080 message-server:latest
```