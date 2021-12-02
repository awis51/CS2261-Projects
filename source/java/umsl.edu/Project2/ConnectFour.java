package umsl.edu.Project2;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public  class ConnectFour {
    //creates the game board array
    public static String[][] createBoard() {
        String[][] gameBoard = new String[6][7];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = " ";
            }
        }
        return gameBoard;
    }
    //prints out board to console
    public static void printBoard(String[][] gameBoard){
        System.out.println(" 0 1 2 3 4 5 6 ");
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[i].length; j++){
                System.out.print("|" + gameBoard[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------------");
    }
    //drops R in column that Red player chooses
    public static void dropRed(String[][] gameBoard){
        System.out.println("Red Player, Choose column (0-6): ");
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        //starts at bottom row and works its way up
        for(int i = 5; i >= 0; i--){
            if(Objects.equals(gameBoard[0][c], "R") || Objects.equals(gameBoard[0][c], "Y")){
                System.out.println("This column is full, try another column.");
                c = scan.nextInt();
            }
            if(Objects.equals(gameBoard[i][c], " ")){
                gameBoard[i][c] = "R";
                break;
            }
        }
    }
    // drops Y in column that Yellow player chooses
    public static void dropYellow(String[][] gameBoard){
        System.out.println("Yellow Player, Choose column (0-6): ");
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        //starts at bottom and works its way up
        for(int i = 5; i >=0; i--){
            if(Objects.equals(gameBoard[0][c], "R") || Objects.equals(gameBoard[0][c], "Y")){
                System.out.println("This column is full, try another column.");
                c = scan.nextInt();
            }
            if(Objects.equals(gameBoard[i][c], " ")){
                gameBoard[i][c] = "Y";
                break;
            }
        }
    }
    //checks for winners
    public static String checkWinner(String[][] gameBoard){
        //checking for horizontal line
        for (int i = 0; i < gameBoard.length - 3; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                //checks if 4 R/Y are together
                if (!Objects.equals(gameBoard[i][j], " ")
                        && (Objects.equals(gameBoard[i][j], gameBoard[i+1][j]))
                        && (Objects.equals(gameBoard[i+1][j], gameBoard[i+2][j]))
                        && (Objects.equals(gameBoard[i+2][j], gameBoard[i+3][j]))){
                    //returns winning pattern
                    return gameBoard[i][j];}
            }
        }
        //checking for vertical line
        for (int j = 0; j < gameBoard[0].length - 3; j++) {
            for (int i = 0; i < gameBoard.length; i++) {
                //Checks  if 4 R/Y are together
                if (!Objects.equals(gameBoard[i][j], " ")
                        && ((Objects.equals(gameBoard[i][j], gameBoard[i][j+1]))
                        && (Objects.equals(gameBoard[i][j+1], gameBoard[i][j+2]))
                        && (Objects.equals(gameBoard[i][j+2], gameBoard[i][j+3])))) {
                    return gameBoard[i][j];}
            }
        }
        //checking / diagonal line
        for (int j = 3; j < gameBoard[0].length; j++) {
            for (int i = 0; i < gameBoard.length - 3; i++) {
                if (!Objects.equals(gameBoard[i][j], " ")
                        &&((Objects.equals(gameBoard[i][j], gameBoard[i + 1][j - 1]))
                        && (Objects.equals(gameBoard[i + 1][j - 1], gameBoard[i + 2][j - 2]))
                        && (Objects.equals(gameBoard[i + 2][j - 2], gameBoard[i + 3][j - 3])))){
                    return gameBoard[i][j];}
            }
        }
        //checking \ diagonal line
        for (int j = 3; j < gameBoard[0].length; j++) {
            for (int i = 3; i < gameBoard.length; i++) {
                if (!Objects.equals(gameBoard[i][j], " ")
                        &&((Objects.equals(gameBoard[i][j], gameBoard[i - 1][j - 1]))
                        && (Objects.equals(gameBoard[i - 1][j - 1], gameBoard[i - 2][j - 2]))
                        && (Objects.equals(gameBoard[i - 2][j - 2], gameBoard[i - 3][j - 3])))){
                    return gameBoard[i][j];}
            }
        }
        return null;
    }

    public static void main(String[] args) {
        boolean loop = true;
        int x = 0;

        String[][] game = createBoard();
        printBoard(game);

        while(loop){
            try{
                if(x % 2 == 0) dropRed(game); //Red starts first and goes every other turn
                else dropYellow(game);
                x++; //keeps track of turns
                printBoard(game);
                if(checkWinner(game) != null){
                    if(Objects.equals(checkWinner(game), "R")) {
                        System.out.println("Player Red has won!");
                        loop = false;
                    }else if (Objects.equals(checkWinner(game), "Y")){
                        System.out.println("Yellow player has won!");
                        loop = false;}
                }
            }catch(InputMismatchException | ArrayIndexOutOfBoundsException p){System.out.println("Try a column 0 - 6.");}
            catch(Exception e){ System.out.println("Something went wrong, try again!");}
        }
    }
}
