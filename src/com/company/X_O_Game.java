package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class X_O_Game {
    public X_O_Game(){

    }

    public void display(){
        System.err.println ("Welcome to X : O Game !!\n" +
                "Intrction\n" +
                "   1. Fuck you \n" +
                "   2. Enter \'Start\' for Start\n" +
                "   3. Enter \'End\' for End");

        String[] symbols = {"X","O"};
        var maxPlayer = 2 ;
        String[] border = new String[9];


        int[][] players = { {1,0,0},
                {2,0,0}};

        Scanner sc = new Scanner(System.in);


        while (true){
            String gameBord =  " 1 | 2 | 3 \n---+---+---\n 4 | 5 | 6 \n---+---+---\n 7 | 8 | 9 ";

            Arrays.fill(border, "0");

            int[][] propWin = { {1,2,3},
                    {4,5,6},
                    {7,8,9},
                    {1,4,7},
                    {2,5,8},
                    {3,6,9},
                    {1,5,9},
                    {3,5,7} };

            System.out.print("Enter Start or End : ");
            var action = sc.next().trim().toLowerCase() ;
            if (action.equals("start")){
                var cureentPlayer = 0;
                cureentPlayer = (int)(Math.round(Math.random()));

                System.out.println(gameBord);

                var firsPlayer = cureentPlayer;

                var gameCon = 1;
                var moveCon = cureentPlayer;
                L:
                while (true) {

                    System.out.println("Player " + (cureentPlayer + 1) + " Enter Number between 1 and 9");
                    var nextStep = "" ;
                    nextStep = sc.next().trim() ;

                    try{
                        var nextStepInt = Integer.parseInt(nextStep);
                        if (nextStepInt >= 1 && nextStepInt <= 9) {
                            if (border[nextStepInt - 1] == "0") {
                                if (cureentPlayer == firsPlayer) {
                                    border[nextStepInt - 1] = symbols[0];
                                    gameBord = gameBord.replace(nextStepInt+"",symbols[0]);
//
                                }else {
                                    border[nextStepInt - 1] = symbols[1];
                                    gameBord = gameBord.replace(nextStep,symbols[1]);
                                }
                                System.out.println(gameBord);
                            }else{
                                System.out.println("This Number is Chosen");
                                continue;
                            }

                            if (gameCon == 5){
                                var i = 0;
                                for (var oneProb: propWin) {
                                    var onePorb1 = border[oneProb[0]-1];
                                    var onePorb2 = border[oneProb[1]-1];
                                    var onePorb3 = border[oneProb[2]-1];

                                    var sum = onePorb1+onePorb2+onePorb3;
                                    if (sum.contains(symbols[0])&&sum.contains(symbols[1])) {
                                        propWin[i] = null;

                                    }else if (sum.equals("XXX")||sum.equals("OOO")){
                                        System.out.println("Player Number "+ (cureentPlayer + 1) + " Is Victorious ^_^");
                                        players[cureentPlayer][1]++;
                                        players[Math.abs(cureentPlayer-1)][2]++;
                                        for (var ruslt: players) {
                                            System.out.println("Player " + ruslt[0] + " : " + " Won " + ruslt[1] + ", Loss " + ruslt[2]);

                                        }
                                        break L;
                                    }
                                    i++;
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
                    gameCon++;
                    moveCon++;
                    cureentPlayer = (moveCon%2);

                }

            }
            else if (action.equals("end")){
                System.exit(1);
                break ;
            }
            else {
                continue;
            }
        }

    }
}
