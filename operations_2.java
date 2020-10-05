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

    public void deleteNode(int key){
        Node prev = tail;
        Node curr = tail.next;
        Node head = tail.next;

        if (curr.value == key)// head and single node case.
        {
            if (curr == curr.next)// single node case
                tail = null;
            else // head case
                tail.next = tail.next.next;
            System.out.println("\nHead element is deleted");
        }

        prev = curr;
        curr = curr.next;

        while (curr != head) {
            if (curr.value == key) {
                if (curr == tail)
                    tail = prev;
                prev.next = curr.next;
                System.out.println("\nElement delted from tail");
                
            }
            prev = curr;
            curr = curr.next;
        }

     System.out.println("\nelement deleted");

    }

    public void searchElement(int key){
        boolean flag=false;
        Node temp=tail.next;
       
        while (temp!=null) {
            if (temp.value==key) {
                flag=true;
                System.out.println("\nelement found");
                break;
            }
            else{
                System.out.println("\nElement not found");
                break;
            }
        }
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
        cll1.searchElement(600);
        cll1.deleteNode(100);
        cll1.print();
        cll1.deleteNode(500);
        cll1.print();
        cll1.deleteNode(300);
        cll1.print();
    }
}
