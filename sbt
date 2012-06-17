#!/bin/bash

 java -Dfile.encoding=UTF8 -Xmx768M -XX:+CMSClassUnloadingEnabled -XX:+UseCompressedOops -XX:MaxPermSize=768m \
	$SBT_EXTRA_PARAMS \
	-Dbuild.time="`date`" \
	-Dsbt.boot.directory=$SBT_BOOT_DIR \
	-jar `dirname $0`/sbt-launch-0.7.7.jar "$@"

