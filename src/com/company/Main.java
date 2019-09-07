package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.err.println ("Welcome to X : O Game !!\n" +
                            "Intrction\n" +
                            "   1. Fuck you \n" +
                            "   2. Enter \'Start\' for Start\n" +
                            "   3. Enter \'End\' for End");

        var maxPlayer = 2 ;


        while (true){

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Start or End : ");
            var action = sc.next().trim().toLowerCase() ;
            if (action.equals("start")){
                var cureentplayer = (Math.round(Math.random()));
                System.out.println("Player "+ (cureentplayer+1) + " Enter some fucking thing" );
                System.out.println(" 1 | 2 | 3 \n" +
                                   "---+---+--- \n" +
                                   " 4 | 5 | 6 \n" +
                                   "---+---+--- \n" +
                                   " 7 | 8 | 9 ");
                break ;
            }
            else if (action.equals("end")){
                System.exit(1);
                break ;
            }
            else {

            }
        }







    }
    public static int PNUM1 () {
        int P = 0;
        Random PC = new Random();
        P = PC.nextInt(2);
        return P;
    }
}
