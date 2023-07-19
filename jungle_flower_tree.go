package main

import (
	"fmt"
	"strings"
)

// HappyHounds is a program to greet your hounds in a happy way
func HappyHounds() {
	fmt.Println("Welcome to Happy Hounds!")
	for i := 0; i < 2000; i++ {
		fmt.Println("Happy hound #"+strings.Repeat("0", 4-len(fmt.Sprintf("%d", i))) + fmt.Sprintf("%d", i)+"!")
	}
	fmt.Println("Thank you for visiting Happy Hounds!")
}

func main() {
	HappyHounds()
}