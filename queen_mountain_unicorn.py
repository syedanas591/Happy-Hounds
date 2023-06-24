#HappyHounds.py

#imports
import sys
import math
import random

#classes
class Dog:
    #constructor
    def __init__(self, name, age):
        self.name = name
        self.age = age

#methods

def bark(self):
    print(self.name + " says BARK!")

def fetch(self, obj):
    if obj == "ball":
        print(self.name + " retrieves the ball!")
    elif obj == "stick":
        print(self.name + " runs and retrieves the stick!") 
    else:
        print(self.name + " doesn't seem interested in " + obj)

def show_age(self):
    print(self.name + " is " + str(self.age) + " years old.")

#data

dogs = [Dog("Spot", 4), Dog("Max", 2), Dog("Buddy", 6)]

#main loop

while run:
    for d in dogs:
        d.bark()
        d.fetch(random.choice(["ball", "stick"]))
        d.show_age()

    run = input("Run again? (y/n): ")
    if run == "n":
        sys.exit()