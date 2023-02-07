#!makefile

COMPOSE_FILE_INFRA = "./etc/docker-compose/local-dev-infra.yml"
COMPOSE_VOLUMES = $(shell docker volume ls --filter "name=${COMPOSE_PROJECT_NAME}*" --format "{{.Name}}")

docker-infra-status:
	docker ps -a \
		--filter "name=${COMPOSE_PROJECT_NAME}*" \
		--format "table {{.ID}}\t{{.Names}}\t{{.Status}}"

docker-infra-up:
	docker-compose -f ${COMPOSE_FILE_INFRA} up -d

docker-infra-down:
	docker-compose -f ${COMPOSE_FILE_INFRA} down

docker-infra-destroy: docker-infra-down
	docker volume rm ${COMPOSE_VOLUMES}

docker-infra-provision-mongodb:
	cd ./etc/docker-compose/config/mongodb && \
	./provision.sh

.PHONY: docker-infra-status \
	docker-infra-up \
	docker-infra-down \
	docker-infra-destroy \
	docker-infra-provision-mongodb