#!/bin/bash
cd Core && mvn clean install && cd ../Testing && mvn clean install -U && cd ../Outbox-Storage && mvn clean install -U && cd ..
