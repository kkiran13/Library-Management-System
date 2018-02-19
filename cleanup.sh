#!/bin/sh

# Cleanup script to be run after every application run to clear out metadata and dangling images
#--------------------------------------------------------------------------------------------
cd dockerfiles ; rm -rf mysql-data ; rm -rf zk-single-kafka-single
#docker stop dockerfiles_libraryconsumer_1 dockerfiles_libraryproducer_1 dockerfiles_kafka_1 dockerfiles_zookeeper_1 dockerfiles_librarydb_1 dockerfiles_newbookconsumer_1 dockerfiles_deletebookconsumer_1 dockerfiles_addcustomerconsumer_1 dockerfiles_deletecustomerconsumer_1
docker ps -q -a | xargs docker rm
