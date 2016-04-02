#!/bin/bash


touch ObjectType
git cat-file -t $1 > ObjectType
