
/**
 * StackArraylist is an implementation of a stack using an arraylist.
 *
 * @author Xhorxhi
 * @version Fall 24
 */
public class StackArraylist<E> extends ArrayList<E>
{
    //checks if empty
    public boolean empty(){
        return size == 0;
    }

    //checks the top of the list
    public E peek(){
        if(!empty()){
            return get(0);
        }
        return null;
    }

    //returns and removes top element
    public E pop(){
        E data = null;
        if(!empty()){
            remove(0);
        }
        return data;
    }

    //adding element to top
    public E push(E data){
        add(0,data);
        return data;
    }

    //searches for an element
    public int search(Object obj){
        int index = 0;
        while(index >= 0 && index < size){
            if(get(index).equals((E)obj)){
                return index;
            }
            else{
                index++;
            }
        }
        return  -1;
    }

}
