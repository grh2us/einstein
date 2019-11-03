# einstein

Setup
1. brew install kafka
2. zkserver start --> This will start up zookeeper on port 2181
3. vim /usr/local/etc/kafka/server.properties and uncomment `listeners=PLAINTEXT://:9092`
and change to `listeners=PLAINTEXT://localhost:9092`
4. kafka-server-start /usr/local/etc/kafka/server.properties
5. Now in a separate tab run `kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test`.
This creates a topic called test where we will produce messages to
6. In that same tab run `kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning`
This will instantiate a consumer to read messages from the topic
called 'test'
7. Now return to IntelliJ and right click on ApiApplication.java and select `run`
8. Using Postman, create a POST request to `http://localhost:8080/produce-message` with
the body being `{"message": "Hello"}`
9. After sending the request you can verify the message was sent by
returning to the terminal tab where the consumer was started