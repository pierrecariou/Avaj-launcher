#!/bin/bash

find . -name "*.java" > sources.txt

javac @sources.txt

if [ $? -eq 0 ]
then
	java main/Main scenario.txt
fi

find . -name "*.class" | xargs rm
