
/**
 * Driver for the entire problem set
 *
 * @author Xhorxhi
 * @version Fall 24
 */
public class DriverRecursionPractice
{
    public static void main(String[] args){
        String str1 = "aeiou & sometimes y";
        System.out.println("Testing vowelToUpperCase (iteratively)");
        System.out.println("Expecting: AEIOU & sOmEtImEs y\n Got: " + recursionPractice.vowelToUpperCase(str1));
        System.out.println("Recursive result: " + recursionPractice.recursionVowelToUpperCase(str1));

        String str2 = "Leaves are falling, autumn is calling!";
        System.out.println("\nTesting vowelToUpperCase with a different string:");
        System.out.println("Expecting: LEAvEs ArE fAllIng, AUtUmn Is cAllIng!\n Got: " + recursionPractice.vowelToUpperCase(str2));
        System.out.println("Recursive result: " + recursionPractice.recursionVowelToUpperCase(str2));
        
        System.out.println("Expecting: 0 for 1\n Got: " + recursionPractice.evenOdd(1));
        System.out.println("Recursive result: " + recursionPractice.recursionEvenOdd(1));
        
        System.out.println("Expecting: 2 for 2\n Got: " + recursionPractice.evenOdd(2));
        System.out.println("Recursive result: " + recursionPractice.recursionEvenOdd(2));
        
        System.out.println("Expecting: 420 for 3241\n Got: " + recursionPractice.evenOdd(3241));
        System.out.println("Recursive result: " + recursionPractice.recursionEvenOdd(3241));
        
        System.out.println("Expecting: 4002 for 2314\n Got: " + recursionPractice.evenOdd(2314));
        System.out.println("Recursive result: " + recursionPractice.recursionEvenOdd(2314));
        
        int[] arr = {2, 4, 6, 8, 10}; // the test array

        System.out.println("\nTesting sumIn (iteratively)");
        System.out.println("Expecting: 4 for {2, 4, 6, 8, 10}, 1, 1, 0 --> " + recursionPractice.sumIn(arr, 1, 1, 0));
        System.out.println("Recursive result: " + recursionPractice.recursionSumIn(arr, 1, 1, 0));

        System.out.println("Expecting: 0 for {2, 4, 6, 8, 10}, 0, 4, 11 --> " + recursionPractice.sumIn(arr, 0, 4, 11));
        System.out.println("Recursive result: " + recursionPractice.recursionSumIn(arr, 0, 4, 11));

        System.out.println("Expecting: 18 for {2, 4, 6, 8, 10}, 2, 4, 7 --> " + recursionPractice.sumIn(arr, 2, 4, 7));
        System.out.println("Recursive result: " + recursionPractice.recursionSumIn(arr, 2, 4, 7));
    }
}
        
    

