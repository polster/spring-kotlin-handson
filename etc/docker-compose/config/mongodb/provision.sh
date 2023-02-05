#!/bin/bash

# Requires:
#
# MONGO_ROOT_USERNAME
# MONGO_ROOT_PASSWORD
# COMPOSE_PROJECT_NAME

echo "$0: Provisioning MongoDB..."

SCRIPT_PATH=$(dirname $0)
DOCKER_NAME=$(docker ps -qf "name=${COMPOSE_PROJECT_NAME}-mongodb")
CONFIG_FILE=db.js

docker cp \
  ${SCRIPT_PATH}/${CONFIG_FILE} \
  ${DOCKER_NAME}:/${CONFIG_FILE}

docker exec \
  ${DOCKER_NAME} \
  mongosh -u ${MONGO_ROOT_USERNAME} -p ${MONGO_ROOT_PASSWORD} admin /${CONFIG_FILE}

docker exec \
  ${DOCKER_NAME} \
  rm /${CONFIG_FILE}

echo "$0: All set, bye!"