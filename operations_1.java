package LinkedList;

public class CircularLinkedList {
    
    public class Node{
        private int value;
        private Node next;

        public Node(int v, Node n){
            value=v;
            next=n;
        }

        public Node(int v){
            value=v;
            next=null;
        }
    }

    private Node tail;
    private int size=0;

    public void addHead(int value){
        Node temp=new Node(value, null);
        if (size==0) {
            tail=temp;
            temp.next=temp;
        }
        else{
            temp.next=tail.next;
            tail.next=temp;
        }
        size++;
    }

    public void addTail(int value){
        Node temp= new Node(value, null);
        
        if (size==0) {
            tail=temp;
            temp.next=temp;
        }
        else{
            temp.next=tail.next;
            tail.next=temp;
            tail=temp;
        }
        size++;
    }

    public void copyList(){
        CircularLinkedList cll2= new CircularLinkedList();
        Node curr =tail.next;
        Node head=curr;
        if (curr!=null) {
            cll2.addTail(curr.value);
            curr=curr.next;
        }

        while (curr!=head) {
            cll2.addTail(curr.value);
            curr=curr.next;
        }
        System.out.println("\nThe new List is");
        cll2.print();
    }

    public void copyListReverse(){
        CircularLinkedList cll3=new CircularLinkedList();
        Node curr=tail.next;
        Node head=curr;
        if (curr!=null) {
            cll3.addHead(curr.value);
            curr=curr.next;
        }
        while (curr!=head) {
            cll3.addHead(curr.value);
            curr=curr.next;
        }
        System.out.println("\nThe new Reversed String is");
        cll3.print();
    }

    public void deleteList(){
        tail=null;
        size=0;
        System.out.println("\nThe list is sucessfully deleted");
    }

    
    public void print() {
        Node temp = tail.next;
        while (temp != tail) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.print(temp.value);
    }

    public static void main(String[] args) {
        CircularLinkedList cll1=new CircularLinkedList();
        cll1.addHead(100);
        cll1.addTail(200);
        cll1.addTail(300);
        cll1.addTail(400);
        cll1.print();
        cll1.copyList();
        cll1.copyListReverse();
        cll1.deleteList();
    }
}
