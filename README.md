# Library-Management-System


### Build and start the service on port 8080
```
bash start_app.sh
```

## Health API Endpoint. GET request
```
curl http://localhost:8080/library/health; echo
```

## Swagger API Endpoint. GET request
```
curl http://localhost:8080/swagger-resources; echo
curl http://localhost:8080/v2/api-docs; echo
```

## List Kafka Streams
```
cd dockerfiles
docker-compose exec kafka kafka-topics --list --zookeeper zookeeper:2181
```

## Consume from kafka
```
cd dockerfiles
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic newBook --from-beginning
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic deleteBook --from-beginning
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic newCustomer --from-beginning
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic deleteCustomer --from-beginning
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic checkoutBook --from-beginning
docker-compose exec kafka kafka-console-consumer --zookeeper zookeeper:2181 --topic returnBook --from-beginning
```

## Check MySQL database
```
cd dockerfiles
docker-compose exec librarydb mysql -U library
show tables;
select * from books;
```

## Produce to Kafka
```
cd dockerfiles
docker-compose exec kafka kafka-console-producer --broker-list kafka:9092 --topic newBook
```

# Below are available API endpoints:
Make sure to have kafka consumer opened on a different terminal to consume posted message from the stream (`Consume from kafka` section above by changing stream name as per the action)
## Add New book
```
curl -H "Content-Type: application/json" -X POST -d '{"name":"BookName","author":"SampleAuthor","publishDate":"10-10-2018","genre":"SampleGenre","price":1000}' http://localhost:8080/library/book/add
```

## Delete book
```
curl -H "Content-Type: application/json" -X POST -d '{"id": 1}' http://localhost:8080/library/book/remove
```

## Add customer
```
curl -H "Content-Type: application/json" -X POST -d '{"firstname": "SampleFirstName", "lastname": "SampleLastName", "age": 20, "address": "SampleAddress"}' http://localhost:8080/library/customer/add
```

## Remove customer
```
curl -H "Content-Type: application/json" -X POST -d '{"id": 1}' http://localhost:8080/library/customer/remove
```

## Checkout book
```
curl -H "Content-Type: application/json" -X POST -d '{"customerId": 101, "bookName": "SampleBookName"}' http://localhost:8080/library/book/checkout
```

## Return book
```
curl -H "Content-Type: application/json" -X POST -d '{"customerId": 101, "bookName": "SampleBookName"}' http://localhost:8080/library/book/return
```

## Cleanup metadata and dangling containers
```
bash cleanup.sh
```