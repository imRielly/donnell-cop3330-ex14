package oop.example;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 Exercise 14 - Tax Calculator
 You don’t always need a complex control structure to solve simple problems.
 Sometimes a program requires an extra step in one case, but in all other cases there’s nothing to do.

 Write a simple program to compute the tax on an order amount.
 The program should prompt for the order amount and the state.
 If the state is “WI,” then the order must be charged 5.5% tax.
 The program should display the subtotal, tax, and total for
 Wisconsin residents but display just the total for non-residents.

 Example Output
 What is the order amount? 10
 What is the state? WI
 The subtotal is $10.00.
 The tax is $0.55.
 The total is $10.55.
 Or

 What is the order amount? 10
 What is the state? MN
 The total is $10.00

 Constraints
 Implement this program using only a simple if statement—don’t use an else clause.
 Ensure that all money is rounded up to the nearest cent.
 Use a single output statement at the end of the program to display the program results.

 Challenges
 Allow the user to enter a state abbreviation in upper, lower, or mixed case.
 Also allow the user to enter the state’s full name in upper, lower, or mixed case.
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        //System.out.println(money.format(amt));
        double wiTax = 0.055;

        System.out.print("What is the order total? ");
        double order = in.nextDouble();
        in.nextLine();

        System.out.print("What is the state? ");
        String state = in.nextLine();
        state = state.toUpperCase();

        boolean isWI = state.equals("WI");
        String output;

        if (isWI) {
            double tax = order * wiTax;
            double total = order + tax;
            output = String.format("The subtotal is %s.\n" +
                    "The tax is %s.\n" +
                    "The total is %s.", money.format(order), money.format(tax), money.format(total));
        }
        else {
            output = String.format("The total is %s.", money.format(order));
        }

        System.out.println(output);
    }
}
