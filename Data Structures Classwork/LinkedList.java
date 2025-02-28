
/**
 * LinkedList data structure implementation.
 *
 * @author Xhorxhi
 * @version Fall 24
 */
public class LinkedList<E> implements List<E>, Queue<E>
{
    class Node<E> {
        E data;
        Node next;
    }
    Node<E> head;
    Node<E> tail;
    int size;

    /**
     * Constructor
     */
    public LinkedList(){
        head = tail = null;
        size = 0;

    }

    /**
     * Adds element
     */
    public boolean add(E data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if(size > 0){
            tail.next = newNode;
            tail = newNode;
        } else{
            //empty linkedlist
            head = tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Gets node at index
     */
    private Node getNode(int index){
        if(index < 0 || index >= size){
            return null;
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Adds at specified index
     */
    public boolean add(int index, E data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if(index == size){
            return add(data);
        } else if(index == 0){
            newNode.next = head;
            head = newNode;
        } else{
            Node preNode = getNode(index - 1);
            if(preNode == null){
                return false;
            }
            newNode.next = preNode.next;
            preNode.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Removes at specified index
     */
    public boolean remove(int index){
        if(index<0||index>=size){
            return false;
        }
        if(index==0){
            //remove first node
            Node tmp = head;
            head = head.next;
            tmp.next = null;
        } else if (index==size-1){
            //remove last node
            Node preTail = getNode(index-1);
            if(preTail != null){
                preTail.next = null;
                tail = preTail;
            }
        } else {
            //remove some in the middle
            Node preNode = getNode(index-1);
            if(preNode != null){
                Node current = preNode.next;
                preNode.next = current.next;
                current.next = null;
            }
        }
        size--;

        if(size == 0){
            head = tail = null;
        }
        return true;
    }

    /**
     * Returns item at specified index
     */
    public E get(int index){
        Node<E> currNode = getNode(index);
        if(currNode == null){
            return null;
        }
        return currNode.data;
    }

    /**
     * Sets a specified index to input element
     */
    public boolean set(int index, E element){
        if(index < 0 || index >= size){
            return false;
        }
        add(index, element);
        remove(index + 1);
        return true;
    }

    /**
     * Searches for the specified element
     */
    public boolean contains(E element){
        Node<E> tmp = head;

        while(tmp != null){
            if(tmp.data.equals(element)){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public String toString(){
        String out = "[";
        Node tmp = head;
        while (tmp != null){
            if(tmp != tail){

                out = out + tmp.data + ", ";
            } else{
                out = out + tmp.data;
            }
            tmp = tmp.next;
        }
        out = out + "]";
        return out;
    }

    /**
     * Checks first element
     */
    public E peek(){
        return get(0);
    }

    /**
     * Returns and removes head node
     */
    public E poll(){
        E data = null;
        if(size != 0){
            data = head.data;
            remove(0);
        }
        return data;

    }

    /**
     * Reversing a list.
     */
    public boolean reverse(){
        if(head == null){
            return false;
        }
        Node<E> pre = null;
        Node<E> curr = head;
        Node<E> next = null;
        tail = head;
        while(curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head = pre;
        return true;
    }

    public static void main(String[] args){
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(0);
        ll.add(1);
        ll.add(3);
        ll.add(2,2);
        ll.add(0,-1);
        System.out.println("ll: " + ll.toString());
        ll.remove(3);
        ll.remove(0);
        ll.remove(1);
        System.out.println("ll after remove: " + ll);
        System.out.println("contains(0): expected true, actual " + ll.contains(0));
        System.out.println("contains(3): expected true, actual " + ll.contains(3));
        System.out.println("get(2), expected null, actual " + ll.get(2));
        System.out.println("get(0), expected 0, actual " + ll.get(0));
        System.out.println("get(1), expected 3, actual " + ll.get(1));
        System.out.println("set(1,1), expected true, actual " + ll.set(1,1));
        System.out.println("set(-1,1), expected false, actual " + ll.set(-1,1));
        System.out.println("ll after all tests: " + ll);

        //bonus reverse test

        System.out.println("List reversed:");
        ll.reverse();
        System.out.println(ll);
    }
}

