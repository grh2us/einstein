#!/bin/bash

rm ./.env
docker-compose stop
docker rm $(docker ps -a -q)

