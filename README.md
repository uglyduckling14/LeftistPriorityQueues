# Assignment 5: Scheduling Priority Queue
## Introduction:
I will use leftist priority queues to find the most efficient way to complete a list of tasks.
## Pseudocode:

### PriorityQueue class:
    public void enqueue(E value){
        E min = find min(value, tree root);
        get right subtree of min until right subtree = null;
        check S values of right and left child of min ;
        if(right S> left S){
            swap right and left child;
        }
    }
    private int getNPL(Node<E> t) {
        if (t == null) return -1;
        return t.npl;
    }
    public E dequeue(){
        delete root;
        merge subtrees of root;
        return root.value;
    }

    public boolean isEmpty(){
        return if(root==null);
    }

    private class Node<E> { //completed??
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
### Assignment5 class:
    public static void schedule(String label, ArrayList<Task> tasks) {
        System.out.println(label);
        /*first number = start time;
          second number = deadline;
          third number = duration;
         */
        enqueue all tasks== time;
        delete root from queue;
        subtract 1 from duration;
        if not completed:
            print( Time+ \t: + root.ID);
            add root back in;
        else:
            print( Time+\t: + root.ID+"**");
    }
## Testing:
    public String print(Node<E> node){
        if(node.right==null) {
            return "" +node.value;
        }return print(node.right);
    }
    public String print(Node<E> node){
        if(node.left==null) {
            return "" +node.value;
        }return print(node.right);
    }
    public static void simpleQueueTest() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.enqueue(9);
        queue.enqueue(7);
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(10);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
    Output:
    1
    3
    5
    7
    9
    10
    public static void simpleQueueTest() {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.enqueue("chicken");
        queue.enqueue("lemon");
        queue.enqueue("apple");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
    Output:
    apple
    chicken
    lemon
