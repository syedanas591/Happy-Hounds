#include <stdio.h>
#include <stdlib.h>

// Function Prototypes
void happyHounds(void);
int checkInput(int);
void displayResults(int);

int main()
{
    // Welcome Message
    printf("Welcome to Happy Hounds!\n\n");

    // Variable Declaration
    int input;
    char repeat;

    do{
        // Call of function to run the game
        happyHounds();
        
        // Prompt user to continue or exit the game
        printf("\nDo you want to play again? (Y/N): ");
        scanf(" %c", &repeat);
    }while(repeat == 'Y' || repeat == 'y');

    // Exit message
    printf("\nThank you for playing Happy Hounds!\n");

    system("pause");
    return 0;
}

void happyHounds()
{
    // Variable declaration
    int input;

    // Prompt user for input
    printf("\nPlease enter a number between 1 and 10: ");
    scanf("%i", &input);

    // Check user input
    int result = checkInput(input);

    // Display results
    displayResults(result);
}

int checkInput(int input)
{
    // Variable declaration
    int result;

    // Check if user input is within range
    if(input > 0 && input <= 10){
        result = 1;
    }else{
        result = 0;
    }

    return result;
}

void displayResults(int result)
{
    // Check result
    if(result == 1){
        printf("\nYou selected: %i\n", result);
        printf("Happy Hounds approve of your choice!\n");
    }else{
        printf("\nThat is an invalid number, try again.\n");
    }
}