# Library-Management-System


### Build and start the service on port 8080
```
cd api
bash start_service.sh
```

## List Kafka Streams
```
docker-compose exec kafka kafka-topics --list --zookeeper zookeeper:2181
```

## Consume from kafka
```
cd api/docker
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic newBook --from-beginning
```

## Produce to Kafka
```
cd api/docker
docker-compose exec kafka kafka-console-producer --broker-list kafka:9092 --topic newBook
```

## Health API Endpoint. GET request
```
curl http://localhost:8080/health; echo

```

## Swagger API Endpoint. GET request
```
curl http://localhost:8080/swagger-resources; echo
curl http://localhost:8080/v2/api-docs; echo
```

## Add new book API Endpoint. Make sure to have kafka consumer opened on a different terminal to consume posted message from the stream (Consume from kafka section above)
```
curl -H "Content-Type: application/json" -X POST -d '{"Name": "SampleBook", "Author": "SampleAuthor", "PublishedDate": "10/10/2010"}' http://localhost:8080/api/addbook
```
