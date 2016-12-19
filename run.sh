#!/bin/bash
mvn clean package
echo "Bash process: $$"
CLASSPATH=${BASE_DIR}$( cd $(dirname $0) ; pwd -P )/target/trap-kill-minus-nine.jar:${HOME}/.m2/repository/net/java/dev/jna/jna/4.2.2/jna-4.2.2.jar
LD_PRELOAD="preload-kill-me-with-parent"
/usr/lib/jvm/java-7-oracle/bin/java -classpath ${CLASSPATH} Test &
while true ; do
    sleep 1
    echo "bash - ping"
done
