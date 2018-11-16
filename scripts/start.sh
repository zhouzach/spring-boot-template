#!/bin/bash

now=`date +%Y-%m-%d`

kill `jps -lm |awk '/prod-0.0.1-SNAPSHOT.jar/{print $1}'`
sleep 3s
nohup java -jar ./prod-0.0.1-SNAPSHOT.jar > /data/logs/web/$now.log 2>&1 &