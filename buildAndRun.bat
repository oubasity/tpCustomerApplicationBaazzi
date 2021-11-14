@echo off
call mvn clean package
call docker build -t ma.emsi/tpCustomerApplicationBaazzi .
call docker rm -f tpCustomerApplicationBaazzi
call docker run -d -p 9080:9080 -p 9443:9443 --name tpCustomerApplicationBaazzi ma.emsi/tpCustomerApplicationBaazzi