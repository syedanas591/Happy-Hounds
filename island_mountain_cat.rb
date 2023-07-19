#HappyHounds.rb

#Greeting
puts "Welcome to Happy Hounds!"

#Require Files
require './Dog.rb'
require './Client.rb'
require './Shelter.rb'

#Create Shelter
@shelter = Shelter.new

#Create Dogs
@dog1 = Dog.new("Fido", "Golden Retriever", 5)
@dog2 = Dog.new("Sparky", "German Shepherd", 2)
@dog3 = Dog.new("Puddles", "Poodle", 3)

#Add Dogs to Shelter
@shelter.add_dog(@dog1)
@shelter.add_dog(@dog2)
@shelter.add_dog(@dog3)

#Create Clients
@client1 = Client.new("Jane Doe", 26, 1)
@client2 = Client.new("John Doe", 28, 5)
@client3 = Client.new("Jessica Johnson", 33, 2)

#Add Clients to Shelter
@shelter.add_client(@client1)
@shelter.add_client(@client2)
@shelter.add_client(@client3)

#Display Shelter
puts "Shelter Info: "
puts @shelter

#Display Dogs
puts "Dog Info: "
puts @dog1
puts @dog2
puts @dog3

#Display Clients
puts "Client Info: "
puts @client1
puts @client2
puts @client3

#Adopt Dog
@client1.adopt_dog(@shelter, @dog1)

#Display Client
puts "Client 1's Info: "
puts @client1

#Unadopt Dog
@client1.unadopt_dog(@shelter, @dog1)

#Display Client
puts "Client 1's Info: "
puts @client1

#Display Shelter
puts "Shelter Info: "
puts @shelter

#Donate Dog
@client2.donate_dog(@shelter, @dog2)

#Display Client
puts "Client 2's Info: "
puts @client2

#Display Shelter
puts "Shelter Info: "
puts @shelter