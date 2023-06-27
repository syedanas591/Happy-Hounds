#include<stdio.h>
#include<string.h>

int main()
{
  char dogName[20];
  char happyMessage[100] = "Happy Birthday to you, ";
  int age;
  int i;
  
  printf("What is your dog's name? \n");
  scanf("%s", dogName);
  
  printf("How old is your dog? \n");
  scanf("%d", &age);
  
  // Append the dog's name to the beginning of the happy message
  strcat(happyMessage, dogName);
  strcat(happyMessage, ", from all of us at Happy Hounds!\n");

  for (i = 0; i < age; i++) {
      //Print the message out the appropriate amount of times
      printf("%s", happyMessage);
  }
  
  return 0;
}