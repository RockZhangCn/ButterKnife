#!/bin/bash
all:
	export JAVA_HOME=/opt/jdk1.8.0_102/
	/opt/gradle-3.3/bin/gradle build

#自动生成了相应的apk文件并重新命名。
