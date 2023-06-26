// File 1 - Happy Hounds.kt

// Imports
import java.util.ArrayList

class HappyHounds { 

// Constant fields
    val MAX_DOGS_ALLOWED = 10
    val MIN_DOGS_ALLOWED = 1
    val SUPPLY_AMOUNT_PER_DOG = 20

// Member variables
    lateinit var listOfDogs: ArrayList<String>
    var amountOfSupplies: Int

// Constructors
    constructor(listOfDogs: ArrayList<String>, amountOfSupplies: Int) {
        this.listOfDogs = listOfDogs
        this.amountOfSupplies = amountOfSupplies
    }

// Member functions
    fun addDog(name: String) {
        if (listOfDogs.size < MAX_DOGS_ALLOWED) {
            listOfDogs.add(name)
        } else {
            println("Cannot add more than 10 dogs to the Happy Hounds.")
        }
    }

    fun removeDog(name: String) {
        if (listOfDogs.size > MIN_DOGS_ALLOWED) {
            listOfDogs.remove(name)
        } else {
            println("Cannot remove the last dog from Happy Hounds.")
        }
    }

    fun countDogs(): Int {
        return listOfDogs.size
    }

    fun getSupplies(): Int {
        return amountOfSupplies
    }

    fun addSupplies(amount: Int) {
        if (amount > 0) {
            amountOfSupplies += amount
        }
    }

    fun spendSupplies() {
        if (amountOfSupplies > 0) {
            amountOfSupplies -= listOfDogs.size * SUPPLY_AMOUNT_PER_DOG
        }
    }
}