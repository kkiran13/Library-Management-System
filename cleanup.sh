#!/bin/sh

# Cleanup script to be run after every application run to clear out metadata and dangling images
#--------------------------------------------------------------------------------------------
cd dockerfiles ; rm -rf mysql-data ; rm -rf zk-single-kafka-single
docker stop $(docker ps -a -q)
docker ps -q -a | xargs docker rm
