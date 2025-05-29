import java.util.Scanner;
public class ListaDoble2{
    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int d) {
            data=d;
            next=null;
            prev=null;
        }
    }
    Node head;
    public ListaDoble2(int[] elements){
        for(int el:elements){
            insert(el);
        }
    }
}
class Principal {
    public static void main(String[] args) {
        ListaDoble2 lista=new ListaDoble2(new int[]{1,2,3,4,5,6,7,8,9,10});
    }
}
