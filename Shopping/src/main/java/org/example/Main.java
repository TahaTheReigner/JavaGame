package org.example;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String item ;
        double price ;
        int quantity;
        char currency = '$';
        double total;

        System.out.println("WHAT ITEM WOULD YOU LIKE TO BUY : ");
        item = scanner.nextLine();

        System.out.println("what is the price for each ? : ");
        price = scanner.nextDouble();

        System.out.println("how many would you like ? : ");
        quantity = scanner.nextInt();

        total = price * quantity;
        System.out.println("\n you have bought " + quantity + " " + item + "/s");
        System.out.println("Your total is " + currency + total);
















        scanner.close();


    }
}

