package org.example;
import java.util.Random;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {


        Random random = new Random();

       boolean isHeads;

       isHeads = random.nextBoolean();
       if (isHeads) {
           System.out.println("HEADS");

       }else  {
           System.out.println("TAILS");
       }




    }
}
