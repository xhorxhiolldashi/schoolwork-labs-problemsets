
/**
 * Stack implementation using linkedlist.
 *
 * @author Xhorxhi
 * @version Fall 24
 */
public class Stack<E> extends LinkedList<E>
{
    //checks if empty
    public boolean empty(){
        return size == 0;
    }

    //checks the top of the list
    public E peek(){
        if(!empty()){
            return head.data;
        }
        return null;
    }

    //returns and removes top element
    public E pop(){
        E data = null;
        if(!empty()){
            data = head.data;
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
        Node<E> tmp = head;
        int index = 0;
       while(tmp != null){
            if(tmp.data.equals((E)(obj))){
                return index;
            }
            tmp = tmp.next;
            index++;
        }
        return  -1;
}
}
