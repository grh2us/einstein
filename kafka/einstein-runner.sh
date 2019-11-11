#!/bin/bash

#Command line parameter specifying how many brokers the kafka cluster should have
NUM_BROKERS=${1}

#Sets host ip address as an environment variable
set -a
echo "HOST_IP_ADDRESS=$(ipconfig getifaddr en0)" >> ./.env
source ./.env


#Start up the kafka cluster with brokers
docker-compose up -d
docker-compose scale kafka=${NUM_BROKERS}

#Create a list of kafka brokers
CONTAINERS=$(docker ps | grep 9092 | awk '{print $1}')
BROKER_LIST=""
for CONTAINER in ${CONTAINERS}; do
    PORT=$(docker port "$CONTAINER" 9092 | sed -e "s/0.0.0.0:/:/g")
    BROKER_LIST="${BROKER_LIST}${HOST_IP_ADDRESS}${PORT},"
done
BROKER_LIST=${BROKER_LIST%?}
echo "These are the kafka brokers: ${BROKER_LIST}"

#Create topics
echo "Waiting for brokers to become available before creating topics..."
sleep 30
#TODO Can update this to create all the necessary topics
kafka-topics --create --zookeeper ${HOST_IP_ADDRESS}:2181 --replication-factor ${NUM_BROKERS} --partitions 3 --topic test
echo "Topics have been successfully created"

#Add broker list ip addresses to the environment
echo "BROKER_LIST=${BROKER_LIST}" >> ./.env
set -a
source ./.env

#Run the api #TODO Can make more robust to find the jar file and not rely on relative paths
java -jar ../target/api-0.0.1-SNAPSHOT.jar




