import java.util.LinkedList;

/**
 * myTree
 *
 * @author Xhorxhi
 * @version Fall 24
 */
public class Tree<E extends Comparable>
{
    public class Node<E extends Comparable>{
        E data;
        Node<E> left;
        Node<E> right;

        public Node(E data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node<E> root;
    int height;
    int size;

    public Tree(){
        root = null;
        height = 0;
        size = 0;
    }

    public void add(E data){
        //check if it'd be the first element
        if(root == null){
            root = new Node(data);
            size++;
            return;
        }
        //check if less than root node
        else{
            //Call add(node, data)
            add(root, data);

        }
    }

    /**
     * 
     */
    public void add(Node<E> node, E data){
        //compare data with current node
        if(node.data.compareTo(data) > 0){
            //look at left subtree
            if(node.left == null){
                //we found where to insert, add data as child here
                Node<E> tmp = new Node<E>(data);
                node.left = tmp;
                size++;
                return;
            }
            //if left is not null, recursively search again
            add(node.left, data);
        } else{
            //look at right subtree
            if(node.data.compareTo(data) < 0){
                if(node.right == null){
                    //we found where to insert, add data as child here
                    Node<E> tmp = new Node<E>(data);
                    node.right = tmp;
                    size++;
                    return;
                }
                //if right is not null, recursively search again
                add(node.right, data);
            }
        }
    }

    public boolean contains(E data){
        return contains(root, data);
    }

    public boolean contains(Node<E> node, E data){
        //base case
        if(node == null){
            return false;
        }
        if (node.data.compareTo(data) == 0){
            return true;
        }
        //recursive case
        if(node.data.compareTo(data) < 0){
            return contains(node.right, data);
        } 
        else {
            return contains(node.left, data);

        }

    }

    public int height(){
        return height(root);
    }

    public int height(Node<E> node){
        //base case
        if(node == null){
            return -1;
        }
        //recursive part
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int depth(E data){
        if(!contains(data)){
            return -1;
        }
        return depth(root, data);
    }

    public int depth(Node<E> node, E data){
        //base case
        if (node.data.compareTo(data) == 0){
            return 0;
        }
        //recursive case
        if(node.data.compareTo(data) < 0){
            return 1 + depth(node.right, data);
        } 
        else {
            return 1+ depth(node.left, data);

        }

    }

    public E getSmallest(Node<E> node){
        if(node.left != null){
            return getSmallest(node.left);
        }
        return node.data;
    }

    public void remove(E data){
        root = remove(root, data);
    }

    private Node<E> remove(Node<E> curr, E data){
        if(curr == null){
            //node not found
            return null;
        }

        if(data.compareTo(curr.data) < 0){
            //data is in the left subtree
            curr.left = remove(curr.left, data);
        } else if(data.compareTo(curr.data) > 0){
            //data is in the right subtree
            curr.right = remove(curr.right, data);
        } else {
            //found the node to remove
            //Case 1 - Leaf node
            if(curr.left == null && curr.right == null){
                return null;
            }

            //Case 2 - One child (right)
            if(curr.left == null){
                return curr.right;
            }

            //Case 2 - One child (left)
            if(curr.right == null){
                return curr.left;
            }

            //Case 3 - Two children
            E smallestValue = getSmallest(curr.right);
            curr.data = smallestValue;
            curr.right = remove(curr.right, smallestValue);
        }

        return curr;
    }

    public boolean equalsShape(Tree tree){
        return equalsShape(root, tree.root);
    }

    public boolean equalsShape(Node t1, Node t2){
        //this method checks if two trees have the same shape
        if(t1 == null && t2  == null){
            return true;
        }
        if(t1 != null && t2 != null){
            return equalsShape(t1.right, t2.right) && equalsShape(t1.left, t2.left);
        }
        return false;
    } 

    public boolean equals(Tree tree){
        return equals(root, tree);
    }

    public boolean equals(Node<E> node, Tree tree){
        if(tree == null){
            throw new NullPointerException("Tree is null");
        }
        if(node == null){
            return true;
        }
        if(!tree.contains(node.data)){
            return false;
        }
        return equals(node.right, tree) && equals(node.left, tree);
    }

    public String toStringBre(){
        LinkedList<Node<E>> list = new LinkedList<Node<E>>();
        list.add(root);
        return toStringBre(list);
    }

    public String toStringBre(LinkedList<Node<E>> list){
        if(list.size() == 0){
            return "";
        }

        Node<E> node = list.poll();

        if(node.left != null){
            list.add(node.left);
        }
        if(node.right != null){
            list.add(node.right);
        }

        return "" + node.data + " " + toStringBre(list);

    }

    public String toStringInOrder(Tree tree){
        return toStringInOrder(root);
    }

    public String toStringInOrder(Node<E> node){
        //base case
        if(node == null){
            return "";
        }

        //left
        String out = toStringInOrder(node.left);

        //current
        out += " " + node.data;

        //right
        out += " " + toStringInOrder(node.right);

        return out;
    }

    public String toStringPre(Node<E> node){
        //base case
        if(node == null){
            return "";
        }
        String out = "";
        //current
        out += node.data;
        //left
        out += toStringPre(node.left);
        //right
        out += toStringPre(node.right);

        return out;
    }

    public String toStringPost(Node<E> node){
        //base case
        if(node == null){
            return "";
        }

        //left
        String out = toStringPost(node.left);
        //right
        out += toStringPost(node.right);
        //root
        out += node.data;

        return out;
    }

    public static void main(String[] args){
        Tree<String> strT = new Tree<String>();
        strT.add("java");
        strT.add("is");
        strT.add("so");
        strT.add("much");
        strT.add("fun");

        System.out.println("strT: " + strT);

        Tree<Integer> intT = new Tree<Integer>();

        intT.add(10);
        intT.add(5);
        intT.add(7);
        intT.add(2);
        intT.add(18);
        intT.add(15);
        intT.add(14);
        intT.add(20);
        intT.add(3);
        intT.add(1);
        intT.add(16);
        System.out.println("intT og: " + intT.toStringInOrder(intT.root));
        intT.remove(10);
        System.out.println("intT after 10 is removed: " + (intT.toStringInOrder(intT.root)));
        intT.remove(3);
        System.out.println("intT (after 3 is removed): " + intT.toStringInOrder(intT.root));
        intT.remove(15);
        System.out.println("intT after 15 is removed: " + intT.toStringInOrder(intT.root));
        intT.remove(18);
        System.out.println("intT after 18 is removed: " + intT.toStringInOrder(intT.root)); 
        System.out.println("height of intT, expected 3: " + intT.height());
        System.out.println("Depth of 7 in intT, expected 2: " + intT.depth(7));

        System.out.println("Testing equals and equalsShape:");

        Tree<Integer> t2 = new Tree<Integer>();

        t2.add(1);
        t2.add(2);
        t2.add(3);
        t2.add(4);
        t2.add(5);

        Tree<Integer> t3 = new Tree<Integer>();

        t3.add(1);
        t3.add(2);
        t3.add(3);
        t3.add(4);
        t3.add(5);

        Tree<Integer> t4 = new Tree<Integer>();

        t4.add(5);
        t4.add(4);
        t4.add(3);
        t4.add(2);
        t4.add(1);

        System.out.println("EqualsShape: comparing t2 and intT, expected false: got: " + t2.equalsShape(intT));

        System.out.println("EqualsShape: comparing t2 and t3, expected true: got: " + t3.equalsShape(t2));

        System.out.println("Equals: comparing t2 and t4, expected true: got: " + t2.equals(t4));

        System.out.println("Equals: comparing t4 and intT, expected false: got: " + t4.equals(intT));

        Tree<String> t5= new Tree<String>();
        t5.add("java");
        t5.add("so");
        t5.add("is");
        t5.add("fun");
        t5.add("much");

        Tree<String> t6 = new Tree<String>();
        t6.add("fun");
        t6.add("is");
        t6.add("so");
        t6.add("java");
        t6.add("much");

        System.out.println("Test Equals, expected true, got: " + t5.equals(t6)); 
        System.out.println("Test EqualsShape, expected false, got: " + t6.equalsShape(t5));  
    }
}
