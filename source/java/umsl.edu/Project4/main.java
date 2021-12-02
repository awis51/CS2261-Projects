package umsl.edu.Project4;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        //input for number of tails and heads
        System.out.println("Enter the number of heads and tails for the Hydra");
        Scanner scan = new Scanner(System.in);
        int heads = scan.nextInt();
        int tails = scan.nextInt();
        //Create object hydra
        Hydra hydra = new Hydra(heads,tails);
        //start simulation and prompt for user input

        while(hydra.isAlive()){
         try{
             System.out.println("Hydra is ready for battle, Choose your move:(1) cut 1 head, (2) cut 1 tail, (3) cut 2 heads, (4) cut 2 tails, (5) minimum moves ");
             int move = scan.nextInt();

             switch(move){
                 case 1:
                     hydra.moveOne();
                     hydra.printResults();
                        break;
                 case 2:
                     hydra.moveTwo();
                     hydra.printResults();
                        break;
                 case 3:
                     hydra.moveThree();
                     hydra.printResults();
                        break;
                 case 4:
                     hydra.moveFour();
                     hydra.printResults();
                        break;
                 case 5:
                     hydra.minMoves();
                        break;
                 default: System.out.println("Try a move 1-5. ");
             }
         }catch(Exception e){
             System.out.println("Something went wrong, try again. ");
         }
        }
    }
}
