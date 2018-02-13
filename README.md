# Library-Management-System


### Build and start the service on port 8080
```
cd api
bash start_service.sh
```

## List Kafka Streams
```
cd api/dockerfiles
docker-compose exec kafka kafka-topics --list --zookeeper zookeeper:2181
```

## Consume from kafka
```
cd api/dockerfiles
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic newBook --from-beginning
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic deleteBook --from-beginning
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic newCustomer --from-beginning
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic deleteCustomer --from-beginning
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic checkoutBook --from-beginning
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic returnBook --from-beginning
```

## Produce to Kafka
```
cd api/dockerfiles
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

# Below are available API endpoints:
Make sure to have kafka consumer opened on a different terminal to consume posted message from the stream (`Consume from kafka` section above by changing stream name as per the action)
## Add New book
```
curl -H "Content-Type: application/json" -X POST -d '{"name":"BookName","author":"SampleAuthor","publishDate":"10/10/2018","genre":"SampleGenre","price":1000}' http://localhost:8080/library/book/add
```

## Delete book
```
curl -H "Content-Type: application/json" -X POST -d '{"id": 100}' http://localhost:8080/library/book/remove
```

## Add customer
```
curl -H "Content-Type: application/json" -X POST -d '{"firstName": "SampleFirstName", "lastName": "SampleLastName", "age": 20, "address": "SampleAddress"}' http://localhost:8080/library/customer/add
```

## Remove customer
```
curl -H "Content-Type: application/json" -X POST -d '{"id": 100}' http://localhost:8080/library/customer/remove
```

## Checkout book
```
curl -H "Content-Type: application/json" -X POST -d '{"customerId": 101, "bookName": "SampleBookName"}' http://localhost:8080/library/book/checkout
```

## Return book
```
curl -H "Content-Type: application/json" -X POST -d '{"customerId": 101, "bookName": "SampleBookName"}' http://localhost:8080/library/book/return
```
