#!/bin/sh
mvn clean package && docker build -t ma.emsi/tpCustomerApplicationBaazzi .
docker rm -f tpCustomerApplicationBaazzi || true && docker run -d -p 9080:9080 -p 9443:9443 --name tpCustomerApplicationBaazzi ma.emsi/tpCustomerApplicationBaazzi