.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.12.1

clean:
	./gradlew clean

build:
	./gradlew clean build

installProject:
	./gradlew clean installDist

run-dist:
	./build/install/app/bin/app

run:
	./gradlew run

build-run: build run

.PHONY: build