package org.example;

import java.util.Arrays;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double principal;
        double rate;

        int timesCompounded;
        int years;
        double amount;


        System.out.print("Enter the principal amount : ");
        principal = scanner.nextDouble();
        System.out.print("Enter the interest rate (in %) : ");
        rate = scanner.nextDouble() / 100;
        System.out.print("Enter the # of times compounded per year :  ");
        timesCompounded = scanner.nextInt();
        System.out.print("Enter the years of compounded per year :  ");
        years = scanner.nextInt();
        amount = principal * Math.pow(1 + rate / timesCompounded , timesCompounded * years);

        System.out.printf("The amount after %d years is %.2f ", years, amount );

        scanner.close();


    }
}
