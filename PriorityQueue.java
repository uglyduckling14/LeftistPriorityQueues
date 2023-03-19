import java.io.File;

public class PriorityQueue<E extends Comparable<E>>{
    Node<E> root;
//    public String print(Node<E> node){
//        if(node.right==null) {
//            return "" +node.value;
//        }return print(node.right);
//    }
//    public int compareTo(E o) {
//        if(o instanceof Integer){
//            return ((Integer)this.value).compareTo((Integer) o);
//        }else {
//            String temp1 = this.value.toString();
//            String temp2 = o.toString();
//            return temp1.compareTo(temp2);
//        }
//    }
    public void enqueue(E value){
        Node<E> newNode = new Node<>(value);
        root= merge(root,newNode);

    }
    private int getNpl(Node<E> t) {
        if (t == null) return -1;
        return t.npl;
    }
    private void swapkids(Node<E> small){
        Node<E> temp = small.left;
        small.left= small.right;
        small.right= temp;
    }
    private void setNullPathLength(Node<E> small){
        if(small.right==null){
            small.npl = 1;
        }else {
            small.npl = small.right.npl + 1;
        }
    }
    private Node<E> merge(Node<E> t1, Node<E> t2) {
        Node<E> small;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        if (t1.value.compareTo(t2.value) < 0) {
            t1.right = merge(t1.right, t2);
            small = t1;
        } else {
            t2.right = merge(t2.right, t1);
            small = t2;
        }
        if (getNpl(small.left) < getNpl(small.right))
            swapkids(small);
        setNullPathLength(small);
        return small;
    }
    public E dequeue(){
        E min = root.value;
        root = merge(root.left,root.right);
        return min;
    }
    public boolean isEmpty(){
        return root==null;
    }
    private class Node<E>{

        Node(E value) {
            this(value,null, null);
        }
        Node(E value, Node<E>left, Node<E> right){
            this.value = value;
            this.left = left;
            this.right = right;
            npl=0;
        }
        public E value;
        public Node<E> left;
        public Node<E> right;
        public int npl;
    }
}
