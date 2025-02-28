/**
 * Problem set 3.2
 * @author Xhorxhi
 * @version Fall 24
 */
public class recursionPractice
{
    /**
     * This method takes a string as input and returns a new string, 
     * generated iteratively.  The new string contains all of the same
     * characters in the same order, except all vowels are in uppercase.
     * 
     * This method should throw an illegal argument exception with an 
     * appropriate message if the input string is null.
     * 
     * @param str The input string.
     * @return A new string with all of the same characters in the same
     * order, except all vowels are in upper case.
     */
    public static String vowelToUpperCase(String str)
    {
        String toReturn = "";
        //if str == null, throw exception
        if(str == null){
            throw new IllegalArgumentException("str shouldn't be null.");
        }

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                String st = str.charAt(i) + "";
                toReturn += st.toUpperCase();
            }
            else{
                toReturn += str.charAt(i);
            }
        }
        return toReturn;
    }

    /**
     * Same as vowelToUppercase, but the recursive version.
     * @param str The input string.
     * @return A new string with vowels uppercased.
     */
    protected static String recursionVowelToUpperCase(String str){
        if(str == null){
            throw new IllegalArgumentException("str shouldn't be null.");
        }
        //base case
        if(str.length() == 0){
            return str;
        }
        if(str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u'){
            String uppered = str.charAt(0) + "";
            String result = uppered.toUpperCase();
            return result + recursionVowelToUpperCase(str.substring(1));

        }
        else{
            return str.charAt(0) + recursionVowelToUpperCase(str.substring(1));
        }

    }

    /**
     * This method take an integer as input an returns an integer such that the
     * order of the digits is reversed and all odd digits are replaced with 0.
     * 
     * @param number An integer.
     * @return An integer such that the order of the digits is reversed and all
     * odd digits are replaced with 0.
     */
    public static int evenOdd(int number)
    {
        String rev = "";
        while(number > 0){
            //if rightmost digit is not even
            if((number % 10) % 2 != 0){
                rev += 0;
            }
            else{
                rev += number % 10;
            }
            number /= 10;
        }
        return Integer.parseInt(rev);
    }

    /**
     * Same as evenOdd, but the recursive version.
     * 
     * @param number An integer.
     * @return An integer such that the order of the digits is reversed and all
     * odd digits are replaced with 0.
     */
    protected static int recursionEvenOdd(int number){
        if(number == 0){
            return 0;
        }
        int digit = number % 10;
        if(digit % 2 != 0){
            digit = 0;
        }
        //place value determination
        return digit * (int) Math.pow(10, helpCountDigits(number) - 1) + recursionEvenOdd(number / 10);
    }

    private static int helpCountDigits(int number) {
        int count = 0;
        while(number > 0){
            count++;
            number /= 10;
        }
        return count;
    }

    /**
     * This method sums all the values in [array[begin], array[end]] that are greater
     * than the input value greaterThan.
     * 
     * Preconditions:  
     * (1) The array is not null 
     * (2) -1 < begin <= end < the number of elements in the array
     * 
     * This method should throw an illegal argument exception with an 
     * appropriate message if any of the preconditions are violated.
     * 
     * @param array The inter array.
     * @param begin The index into the array in which to begin the sum.
     * @param end The index into the array in which to end the sum.
     * @param greaterThan  Only sum elements if they are greater than this input.
     * @return The sum of elements in [array[begin], array[end]] whose values are
     * greater than the input value.
     */
    public static int sumIn(int[] array, int begin, int end, int greaterThan)
    {
        if(array == null || begin < 0 || begin > array.length || begin > end || end > array.length){
            throw new IllegalArgumentException("array may be null, or out of bounds indexes provided");
        }
        int sum = 0;
        for(int i = begin; i <= end; i++){
            if(array[i] > greaterThan){
                sum += array[i];
            }
        }
        return sum;
    }

    /**
     * Same as sumIn, but the recursive version.
     * @param array The inter array.
     * @param begin The index into the array in which to begin the sum.
     * @param end The index into the array in which to end the sum.
     * @param greaterThan  Only sum elements if they are greater than this input.
     * @return The sum of elements in [array[begin], array[end]] whose values are
     * greater than the input value.
     */
    protected static int recursionSumIn(int[] array, int begin, int end, int greaterThan){
        if(array == null || begin < 0 || begin > array.length || begin > end || end > array.length){
            throw new IllegalArgumentException("array may be null, or out of bounds indexes provided");
        }

        //base case 1
        if(begin == end){
            if(array[begin] > greaterThan){
                return array[begin];
            }
            else{
                return 0;
            }
        }
        //recursive case 1
        if(array[begin] > greaterThan){
            int temp = begin;
            temp = begin + 1;
            return array[begin] + recursionSumIn(array,temp,end,greaterThan);
        }
        else{

            return recursionSumIn(array,begin+1,end,greaterThan);
        }
    }

}
 