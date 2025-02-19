#!/bin/bash

app_name="model-one"
app_version="0.0.1-SNAPSHOT"
app_port="30001"

java_opts="-Xms1536m -Xmx1536m -Xmn1024m -Xss256K -XX:SurvivorRatio=4 -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=92 -XX:+UseCMSInitiatingOccupancyOnly"

nohup java -server -Duser.timezone=Asia/Shanghai -jar $java_opts ${app_name}-${app_version}.jar --server.port=$app_port --spring.application.name=$app_name >nohup.log 2>&1 &

#echo "${app_name}-${app_version}服务启动成功"