Ex1 - Number Converter and Calculator

This project implements a number formatting converter and calculator that can handle numbers in bases ranging from 2 to 16. The program uses a specific string-based representation for numbers and performs conversions, validations, and basic arithmetic operations.

Main Program (Ex1Main)

The main program provides an interactive interface to:
1)Input two numbers in a specific string-based format.
2)Convert the numbers to decimal format.
3)Perform addition and multiplication of the numbers.
4)Display the results in a user-specified base (2-16).
5)Identify the maximum result among the original numbers, addition, and multiplication results.

Functions (Ex1)

1. number2Int (String num)
Converts a number from its string-based format to its decimal (base 10) representation.
Input: String in the format <number><b><base>.
Output: Decimal representation as an integer, or -1 if the input format is invalid.

2)whichNumber(char base)
Determines the numeric value of a given character.
Input: A single character representing a digit or base (e.g., A for base 10).
Output: Integer value corresponding to the character, or -1 for invalid input.

3. isNumber(String a)

Validates if a string is in a valid number format.
Input: A string representing a number.
Output: Boolean (true if valid, false otherwise).

4. int2Number(int num, int base)
Converts a decimal number into a string representation in a specified base.
Input: Integer number and base (2-16).
Output: String representation in the specified base, or an empty string for invalid inputs.

5. maxIndex(int a, int b, int add, int multiply, String add1, String multiply1)
Identifies and displays the maximum value among the given numbers and operations.
Input: Two numbers (a and b), their addition and multiplication results, and their string representations in a specific base.
Output: Prints the maximum value and its representation.

author : noam braun
