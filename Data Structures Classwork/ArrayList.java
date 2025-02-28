
/**
 * Arraylist data structure implementation.
 *
 * @author Xhorxhi
 * @version Fall 24
 */
public class ArrayList<E> implements List<E>
{
    protected Object[] arr;
    protected int size;
    public static final int DEFAULT = 10;

    /**
     * Constructor
     * Initialize instance varaiable, arr
     */
    public ArrayList() {
        arr = new Object[DEFAULT];
        size = 0;
    }

    /**
     * Adds at specified element
     */
    public boolean add(int index, E val){
        if(index < 0 || index > size){
            return false;
        }
        if(size == arr.length){
            return false;
        }
        for(int i = size - 1; i >= index; i--){
            arr[i+1] = arr[i];
        }
        arr[index] = val;
        size++;
        return true;
    }

    /**
     * Adds to end
     */
    public boolean add(E val){
        return add(size, val);
    }

    /**
     * Returns size
     */
    public int size(){
        return size;
    }

    /**
     *Deleting values within array.
     *
     *@param index index to remove
     *
     *@return whether it was found and performed
     */
    public boolean remove(int index){
        //verifying index
        if(index < 0 || index > (size-1)){
            return false;
        }
        //start 1 point after index, and set the previous element equal to the current element of index as long as you are within size
        for(int i = index + 1; i < size; i++){
            arr[i-1] = arr[i];
        }
        size --;
        return true;
    }

    /**
     * Searches for value
     */
    public boolean contains(E value) {
        for(int i = 0; i < size; i++){
            Object item = arr[i];
            if(((E)item).equals(value)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String out = "[";
        for(int i = 0; i < size - 1; i++){
            out += (E)arr[i] + ", ";
        }
        if(size > 0){
            out += (E)arr[size-1];
        }
        out += "]";
        return out;
    }

    /**
     * Returns value at index
     */
    public E get(int index){
        if(index < 0 || index >= size){
            return null;
        }
        return (E)arr[index];
    }

    /**
     * Sets value at index to element
     */
    public boolean set(int index, E element){
        if(index < 0 || index >= size){
            return false;
        }
        arr[index] = element;
        return true;
    }

    
    public static void main(String args[]){
        ArrayList<String> str = new ArrayList<String>();
        str.add("Java");
        str.add(1, "is");
        str.add("not");
        str.add("so");
        str.add("much");
        str.add("fun");
        System.out.println(str);
        str.remove(2);
        System.out.println("contains not? " + str.contains("not"));

    }

}
