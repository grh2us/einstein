# einstein
Setup
1. From the top level directory run `mvn clean install`
2. Now cd into `kafka`
3. Run `./einstein-runner.sh 3`. This will bring up a kafka cluster
with three brokers while starting the API as well
4. Using Postman, create a POST request to `http://localhost:8080/produce-message` with
the body being `{"message": "Hello"}`
5. This message can consumed by starting a kafka console consumer ex:
`kafka-console-consumer --bootstrap-server <BROKER> --topic test --from-beginning` where BROKER
is one of the ip addresses with port number outputted by the runner script
6. Once done running the app, you can `ctrl + c` it and then run `./einstein-cleanup.sh` to clean up
the kafka cluster

# Kafka-Docker Details
Details on the other files in the kafka directory can be found here:
https://github.com/wurstmeister/kafka-docker
