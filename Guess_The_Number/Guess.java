import java.util.Random;
import java.util.Scanner;

public class Guess{
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        
        int x = rand.nextInt(100) ; 
        int guess;
        int tries = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100... Can you guess it?");

       do{
            guess=sc.nextInt();
            tries++;
            if (guess>x){
                System.out.println("guessed too high"); 
            }
            else if(guess<x){
                System.out.println("guessed too low");
            }
            else{
                System.out.println("you guessed correct in "+tries+" tries");

            }
       }
       while(guess != x);

        sc.close();
    }
}
