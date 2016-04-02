#!/bin/bash



if [ $2="0" ]
then
	touch blabla
	git cat-file -t $1 >> blabla
fi
if [ $2="2" ]
then
	git cat-file -t $1 > blabla
fi