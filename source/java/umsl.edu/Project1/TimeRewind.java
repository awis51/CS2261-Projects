package umsl.edu.Project1;

import java.util.InputMismatchException;
import java.util.Scanner;
/* Function TimeRewind will take input time and subtract 45 minutes to determine what time needs to be set for the alarm.
*  First it listens for data input from user, then it will check if data is within the data range,24hr format.
*  If it is in the correct format it will proceed and subtract 45 minutes. If the subtraction results in the M for Minutes to be negative,
*  it will add 60 minutes to get the true value since M is on a scale of 0-60. It will then subtract 1 hour to reflect the subtraction of M.
*  Once the calculations are done it will print out the new time to set the alarm. If it didn't accept the user input,
*  it prints out to try again.*/
public class TimeRewind {
    public static void main(String[] args) {
        int x = 0;
        try {
            do {
                System.out.print("Enter get out of bed time: ");

                Scanner input = new Scanner(System.in);
                int H = input.nextInt();
                int M = input.nextInt();
                if ((00 <= H && H <= 23) && (00 <= M && M <= 59)) { //checks if num is in 24HR range, then subtracts the min by 45.
                    M = M - 45;
                    if (M < 00) { // checks if M is negative, if true, gets rid of negative value and subtracts H
                        M = 60 + M;
                        H = H - 1;
                    }
                    System.out.println(String.format("%02d", H) + ":" + String.format("%02d", M));
                    x++;
                } else
                    System.out.println("Number not accepted, Try again in 24HR format.");
            }
            while (x != 1);
        } catch(InputMismatchException e) {
            System.out.println("OOPS, Wrong format input. Run program again in numerical format, seperated by a space.");
        }
    }
}