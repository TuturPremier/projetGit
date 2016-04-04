#!/bin/bash


touch RecupCommande
git cat-file -p $1 > RecupCommande
