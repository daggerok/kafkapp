kafkapp [![build](https://travis-ci.org/daggerok/kafkapp.svg?branch=master)](https://travis-ci.org/daggerok/kafkapp)
=======

```fish
docker-compose --project-name=kafkapp up
```

```fish
docker-compose --project-name=kafkapp up

rm -rf build/kafka-docker
git clone -b 0.10.0 https://github.com/wurstmeister/kafka-docker.git build/kafka-docker
# edit build/kafka-docker/docker-compose-single-broker.yml 
# comment KAFKA_ADVERTISED_HOST_NAME
# update 'topics'
docker-compose --project-name=kafkapp -f build/kafka-docker/docker-compose-single-broker.yml up
```

```fish
gradle --parallel bootRun
```
