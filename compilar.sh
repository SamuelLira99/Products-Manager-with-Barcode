#!/bin/bash

clear
javac src/*.java -d bin
cd bin
rm ../Marquinhos.jar
jar cfm ../Marquinhos.jar ../manifest.mf *.class ../style.css ../img

if [ "$1" == "e" ]; then
  cd ..
  ./executar.sh
fi
