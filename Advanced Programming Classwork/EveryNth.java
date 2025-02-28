import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * In-class problem 1, demonstration
 * of using command line to execute code.
 * @author Xhorxhi Olldashi
 * @version Spring 2025
 * 
 */

public class EveryNth {
    public static void main(String[] args) throws FileNotFoundException {
        int n = 0;	//number of words to skip

        //Check command line argumemts
        if (args.length == 0 ) {
            System.out.println("Incorrect number of arguments");
            System.exit(1);
        }

        // grab n and check to see if its a positive number.
        try {
            n = Integer.parseInt(args[0]);
        }
        catch(NumberFormatException e){
            System.out.println("Need to specify a positive integer");
            System.exit(1);
        }

        // Create an input scanner from the standard input
        Scanner scnr = new Scanner(System.in);
		
        // Get the input

        int counter = 0;
        String word = "";
        while(scnr.hasNext()){
            word = scnr.next();
            counter++;

        // Display every nth word
        
            if(counter % n == 0){
                System.out.print(word + " ");

            }

        }
            
            
    }
}
