#!/bin/sh

nohup java -jar code-generator-1.0.1-SNAPSHOT.jar && tail -200f nohup.out &