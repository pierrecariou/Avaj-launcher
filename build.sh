#!/bin/bash
# File              : build.sh
# Author            : Pierre Cariou <pierrecariou@outlook.fr>
# Date              : 30.10.2022
# Last Modified Date: 30.10.2022
# Last Modified By  : Pierre Cariou <pierrecariou@outlook.fr>

find . -name "*.java" > sources.txt

javac @sources.txt

if [ $? -eq 0 ]
then
	java Avaj resources/scenario.txt
fi

rm *.class
