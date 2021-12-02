package umsl.edu.Project4;

public class Hydra {
    private int heads;
    private int tails;
    protected boolean alive = true;
    private int moves;

    public Hydra(){}

    public Hydra(int heads, int tails){
        this.heads = heads;
        this.tails = tails;
    }

    public void setHeads(int heads) {
        this.heads = heads;
    }

    public int getHeads() {
        return this.heads;
    }

    public void setTails(int tails) {
        this.tails = tails;
    }

    public int getTails() {
        return this.tails;
    }

    public boolean isAlive(){
        if(this.tails == 0) {
            if (this.heads == 0) {
                this.alive = false;
                System.out.println("The Hydra is dead!!");
            } else
                this.alive = true;
        }
        return this.alive;
    }

    public void isHeadless(){
        if(this.heads == 0)
            if(this.tails > 0) {
                System.out.println("Look Out! The Hydra is headless!!!");
        }
    }

    public void moveOne(){
        if(heads == 0){
            System.out.println("Hydra is headless! pick a different move!");
        }else if((tails == 0)&& (heads == 1)){
            setHeads(0);

        }
        moves++;
    }

    public void moveTwo(){
        if(tails == 0){
            System.out.println("There are no tails left! Pick a different move!");
           }else{
            int tail = getTails();
            setTails(tail+1);
            moves++;}
        isHeadless();
    }

    public void moveThree(){
        if(heads < 2){
            System.out.println("Hydra has less than two heads! Choose a different move!");
        }else{
        int oldHead = getHeads();
        int newHead = oldHead - 2;
        setHeads(newHead);
        moves++;
        }
        isHeadless();
    }

    public void moveFour(){

        if(tails < 2){
            System.out.println("Hydra has less than 2 tails! Pick a different move!");
        }else{
        int oldTail = getTails();
        int newTail = oldTail - 2;
        setTails(newTail);
        setHeads(getHeads()+1);
        moves++;
        }
        isHeadless();
    }

    public void printResults() {
         System.out.println("There are "+ heads + " heads and "+ tails +" tails");
    }

    public void minMoves(){
        int h = heads;
        int t = tails;
        int m = moves;
        boolean a = true;
            while(a){
                if(h > 15 || t > 15){
                    System.out.println("Hydra is impossible to kill!!");
                    this.alive = false;
                    break;
                } if(h == 0)
                    if(t == 0){
                    a = false;
                } if(h >= 2){
                    h = h - 2;
                    m++;
                } if(t >= 2){
                    t = t - 2;
                    h = h + 1;
                    m++;
                } if(h == 1){
                    h = 0;
                    m++;
                } if(t == 1) {
                    t = t + 1;
                    m++;
                }
            }
        System.out.println( m + " Minimum number of moves");
    }
}
