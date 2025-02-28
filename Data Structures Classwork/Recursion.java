
/**
 * Recursion practice
 *
 * @author Xhorxhi
 * @version Fall 24
 */
public class Recursion
{
    public static double powerOfN(double n, double p){

        if(p > 0){
            return (n * powerOfN(n, p-1));
        }
        else
        {
            return 1;
        }

    }

    public static int sum(int n){
        if(n > 0){
            return n + sum(n-1);
        }
        else{
            return -1;
        }
    }

    public static String removeP(String str ){

        //base case
        if(str.length() == 0){
            return "";
        }
        if( str.charAt(0) == 'p'){
            return removeP(str.substring(1));
        }
        return str.charAt(0) + removeP(str.substring(1));

    }

    public static String changePi(String str){
        //base case
        if(str.length() == 0 || str.length() == 1){
            return str;
        }
        if(str.charAt(0) == 'p' && str.charAt(1) == 'i'){
            return "3.14" + changePi(str.substring(2));
        }
        return str.charAt(0) + changePi(str.substring(1));

    }

    public static String pairStar(String str) {
        if(str.length() < 2){
            return str;
        }

        if(str.charAt(0) == str.charAt(1)){
            return str.charAt(0) + "*" + pairStar(str.substring(1));
        } else{
            return str.charAt(0) + pairStar(str.substring(1));

        }
    }

    public static String reverseString(String str) {
        if (str.length() < 2) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void toh(int n, String source, String destination, String intermediate){
        //base case
        if (n < 1){
            return;
        }
        toh(n-1, source, intermediate, destination);
        System.out.println("Move " + n + " disk from " + source + " to " + destination);
        toh(n-1, intermediate, destination, source);
    }

    public static int nCombinations(int n) 
    {
        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return 1;
        } 
        return nCombinations(n - 1) + nCombinations(n - 2);
    }

    public static void main(String args[]){
        System.out.println("remove p from xpx; " + removeP("xpx"));
        System.out.println("remove pi from pixpippi; " + changePi("pixpippi"));
        System.out.println("toh with 1 disc");
        toh(1, "s", "d", "i");
        System.out.println("---------------------------------");
        System.out.println("toh with 2 disc");
        toh(2, "s", "d", "i");
        System.out.println("---------------------------------");
        System.out.println("toh with 3 disc");
        toh(3, "s", "d", "i");
        System.out.println("---------------------------------");
        System.out.println("toh with 4 disc");
        toh(4, "s", "d", "i");
        System.out.println("---------------------------------");
        System.out.println("staircase(1) = " + nCombinations(1)); // Output: 1
        System.out.println("staircase(2) = " + nCombinations(2)); // Output: 1
        System.out.println("staircase(3) = " + nCombinations(3)); // Output: 2
        System.out.println("staircase(4) = " + nCombinations(4)); // Output: 3
        System.out.println("staircase(5) = " + nCombinations(5)); // Output: 5
        System.out.println("staircase(6) = " + nCombinations(6)); // Output: 8
        System.out.println("powerOfN(2, 3) = " + powerOfN(2, 3)); // Output: 8.0
        System.out.println("powerOfN(5, 0) = " + powerOfN(5, 0)); // Output: 1.0
        System.out.println("powerOfN(3, 2) = " + powerOfN(3, 2)); // Output: 9.0
        System.out.println("powerOfN(2.5, 3) = " + powerOfN(2.5, 3)); // Output: 15.625
        System.out.println("powerOfN(10, 2) = " + powerOfN(10, 2)); // Output: 100.0
        System.out.println("sum(5) = " + sum(5)); // Output: 15
        System.out.println("sum(3) = " + sum(3)); // Output: 6
        System.out.println("sum(1) = " + sum(1)); // Output: 1
        System.out.println("sum(0) = " + sum(0)); // Output: -1
        System.out.println("sum(-3) = " + sum(-3)); // Output: -1
        System.out.println("reverseString(\"hello\") = " + reverseString("hello")); // Output: "olleh"
        System.out.println("reverseString(\"abcd\") = " + reverseString("abcd"));   // Output: "dcba"
        System.out.println("reverseString(\"racecar\") = " + reverseString("racecar")); // Output: "racecar"
        System.out.println("pairStar(\"hello\") = " + pairStar("hello")); // Output: "hel*lo"
        System.out.println("pairStar(\"xxyy\") = " + pairStar("xxyy"));   // Output: "x*xy*y"
        System.out.println("pairStar(\"aaaa\") = " + pairStar("aaaa"));   // Output: "a*a*a*a"

        
    }

}