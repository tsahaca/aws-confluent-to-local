#export-import-cert
#!/bin/bash
   
RED='\e[31m'
NOCOLOR='\033[0m'
GREEN='\e[92m'

host=$1
port=$2

echo -e "${GREEN}Deleting old certificates and key stores"

rm ${host}.pem ${host}.der 


echo -e "${GREEN}Exporting certificates from  ${host}"
echo -e ${NOCOLOR}

openssl s_client -showcerts -connect $host:$port </dev/null 2>/dev/null|openssl x509 -outform PEM > ${host}.pem

echo -e "${GREEN}Converting Certificates to DER format"

openssl x509 -in ${host}.pem -inform pem -out ${host}.der -outform der

echo -e "${GREEN}Importing Certificates into cacerts"

keytool -noprompt -delete -alias $host -keystore cacerts -storepass changeit

keytool -noprompt -importcert -alias $host -keystore cacerts -storepass changeit -file ${host}.der



