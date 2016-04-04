#!/bin/bash


touch RecupCommande
git cat-file -t $1 > RecupCommande
