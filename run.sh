#!/bin/bash
java -Djavax.net.ssl.trustStore=config/cacerts  -jar target/aws-confluent-to-local-0.0.1-SNAPSHOT.jar