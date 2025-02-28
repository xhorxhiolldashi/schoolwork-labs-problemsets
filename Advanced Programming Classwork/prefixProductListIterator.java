import java.util.*;

/**
 * Iterates through a List<Integer> and returns prefix products
 * over its values.
 * @author Xhorxhi Olldashi
 * @version Spring 2025
 * 
 */

public class prefixProductListIterator implements java.util.Iterator<Integer> {

    /** the iterator to use for this list */
    private final Iterator<Integer> iterator;

    /** the product of the elements while iterating */
    private int product;

    /** a counter to keep track of where the iterator is */
    private int count;

    /** generic list to use */
    private final List<Integer> list;

    /**
     * Constructor to take in a list and
     * perform the operations. It will initialize
     * the instance iterator to the param list's
     * iterator, as well as the count and product.
     * 
     * @param list the list specified to be taken in
     * 
     */

    public prefixProductListIterator(List<Integer> listToUse){
        list = listToUse;
        this.iterator = list.iterator();

        count = 0;
        product = 1;

    }

    /**
     * Checks to see if there is a next element
     * within the list.
     * 
     * @return whether or not there are any more
     * elements to visit and compute
     */
    
    @Override
    public boolean hasNext(){
        return count < list.size();
    }

    /**
     * Utilizes the list's iterator to get the next
     * value and perform the multiplication process.
     * 
     * @return the next value in the sequence
     */

    @Override
    public Integer next(){
        
        product = product * iterator.next();
        count++;
        return product;
    }

    /**
     * main method to test prefixProductListIterator.
     * 
     */

    public static void main(String[] args) {

        /** first iterator to test: vector */
        Vector<Integer> vector = new Vector<Integer>();

        /** population of vector 1 through 5 */
        for(int i = 1; i < 6; i++){
            vector.add(i);
        }

        /** constructing iterator */
        prefixProductListIterator iter1 = new prefixProductListIterator(vector);

        System.out.println("Vector contents: 1, 2, 3, 4, 5");
        //1 x 1 = 1
        //1 x 2 = 2
        //2 x 3 = 6
        //6 x 4 = 24
        //24 x 5 = 120
        System.out.println("Expected: 1, 2, 6, 24, 120 ");
        System.out.println("Vector Iterator execution:");

        while(iter1.hasNext()){
            System.out.println(iter1.next());
        }

        System.out.println();


        /** second iterator to test: stack */
        Stack<Integer> stack = new Stack<Integer>();

        /** population of stack 1 through 5 */
            for(int i = 1; i < 6; i++){
                stack.add(i);
            }

            /** constructing iterator */
            prefixProductListIterator iter2 = new prefixProductListIterator(stack);

            System.out.println("Stack contents: 1, 2, 3, 4, 5");
            //1 x 1 = 1
            //1 x 2 = 2
            //2 x 3 = 6
            //6 x 4 = 24
            //24 x 5 = 120
            System.out.println("Expected: 1, 2, 6, 24, 120 ");
            System.out.println("Stack Iterator execution:");

            while(iter2.hasNext()){
                System.out.println(iter2.next());
            }

            System.out.println();


        /** third iterator to test: LinkedList */
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        
        /** population of linkedList 1 through 5 */
            for(int i = 1; i < 6; i++){
                linkedList.add(i);
            }

            /** constructing iterator */
            prefixProductListIterator iter3 = new prefixProductListIterator(linkedList);

            System.out.println("LinkedList contents: 1, 2, 3, 4, 5");
            //1 x 1 = 1
            //1 x 2 = 2
            //2 x 3 = 6
            //6 x 4 = 24
            //24 x 5 = 120
            System.out.println("Expected: 1, 2, 6, 24, 120 ");
            System.out.println("LinkedList Iterator execution:");

            while(iter3.hasNext()){
                System.out.println(iter3.next());
            }

            System.out.println();

    }

}