# Kafkabasic

Kafka --> kafka_2.12-2.3.0
Zookeeper --> zookeeper-3.4.14

zookeeper:
>zkserver

Start kafka server: 
>zookeeper-server-start E:\KafkaSW\kafka_2.12-2.3.0\config\server.properties

topic creation:
/bin/windows>kafka-topics.bat --create --zookeeper localhost:2182 --replication-factor 1 --partitions 1 --topic kolluTopic

Test URLS:

http://localhost:9091/publish/kollu1

http://localhost:9091/publishJson
