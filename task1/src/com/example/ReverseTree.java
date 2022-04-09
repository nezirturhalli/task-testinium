package com.example;

import java.util.Scanner;

public class ReverseTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Num: ");
        int num = sc.nextInt();
        sc.close();
        if (num <= 0) {
            System.out.println("Number must be greater than zero!");
        } else {
            for (int i = 0; i < num; i++) {
                for (int k = num; k >= (2 * i + 1); k--) {
                    System.out.print("*");
                }
                System.out.println();

            }
        }
    }
}
