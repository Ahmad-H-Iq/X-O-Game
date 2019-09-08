package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.err.println ("Welcome to X : O Game !!\n" +
                            "Intrction\n" +
                            "   1. Fuck you \n" +
                            "   2. Enter \'Start\' for Start\n" +
                            "   3. Enter \'End\' for End");
        String[] symbols = {"X","O"};
        var maxPlayer = 2 ;
        String[] border = new String[9];
        Arrays.fill(border, "0");

        int[][] propWin = { {1,2,3},
                            {4,5,6},
                            {7,8,9},
                            {1,4,7},
                            {2,5,8},
                            {3,6,9},
                            {1,5,9},
                            {3,5,7} };

        int[][] players = { {1,0,0},
                            {2,0,0}};

        while (true){

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Start or End : ");
            var action = sc.next().trim().toLowerCase() ;
            if (action.equals("start")){
                var cureentPlayer = 0;
                cureentPlayer = (int)(Math.round(Math.random()));
                System.out.println(" 1 | 2 | 3 \n" +
                                   "---+---+---\n" +
                                   " 4 | 5 | 6 \n" +
                                   "---+---+---\n" +
                                   " 7 | 8 | 9 ");

                var firsPlayer = cureentPlayer;

                var gameCon = 1;
                var moveCon = 0;
                while (true) {
                    if (gameCon == 1)
                        moveCon = cureentPlayer;

                    System.out.println("Player " + (cureentPlayer + 1) + " Enter Number bieewin 1 and 9");
                     var nextStep = "" ;
                     nextStep = sc.next() ;

                    try{
                        var nextStepInt = Integer.parseInt(nextStep);
                        if (nextStepInt >= 1 && nextStepInt <= 9) {
                            if (border[nextStepInt - 1] == "0")
                                if (cureentPlayer == firsPlayer)
                                    border[nextStepInt - 1] = symbols[0];
                                else
                                    border[nextStepInt - 1] = symbols[1];

                            else{
                                System.out.println("This Number is Chosen");
                                continue;
                            }

                            if (gameCon == 5){
                                for (var oneProb: propWin) {
                                    var onePorb1 = border[oneProb[0]-1];
                                    var onePorb2 = border[oneProb[1]-1];
                                    var onePorb3 = border[oneProb[2]-1];

                                    var sum = onePorb1+onePorb2+onePorb3;

                                    if (sum.equals("XXX")||sum.equals("OOO")){

                                        break;
                                     }


                                }
                            }



                        }else {
                            System.err.println("wrong Number");
                            continue;
                        }

                    }
                    catch (Exception e){
                        System.out.println("wrong input. ");
                        continue;

                    }





                    cureentPlayer = (moveCon%2)+1;
                    gameCon++;
                    moveCon++;
                }

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
