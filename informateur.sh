#!/bin/bash


touch ObjectInfo
git cat-file -p $1 > ObjectInfo
