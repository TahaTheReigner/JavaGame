package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        boolean isStudent = false;
        boolean isSenior = false;
        double price = 9.99;

        if (isStudent) {
            if (isSenior) {
                System.out.println("You got a Senior discout of 20%");
                System.out.println("You got a Student discout of 10%");
                price *= 0.7;
            }
            else {
                System.out.println("You got a Student discout of 10%");
                price *= 0.9;
            }
        }
        else {
            if (isSenior) {
                System.out.println("You got a Senior discout of 20%");
                price *= 0.8;
            } else {
                price *= 1;

            }

        }
        System.out.printf("the price of a ticket is $%.2f", price);

    }
}


