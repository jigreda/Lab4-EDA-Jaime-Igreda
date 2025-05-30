import java.util.Scanner;
public class ListaCircular2 {
    static class Node {
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    Node head=null;
    public void insert(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            head.next=head;
        }else{
            Node temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.next=head;
        }
    }
    public void printList(){
        if(head==null){
            System.out.println("Lista vacia");
            return;
        }
        Node temp=head;
        do{
            System.out.print(temp.data+" ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }
    public void deleteByKey(int key){
        if(head==null) return;
        Node curr=head, prev=null;
        do{
            if(curr.data==key){
                if(prev==null){ // eliminar cabeza
                    if(head.next==head){
                        head=null;
                    }else{
                        Node last=head;
                        while(last.next!=head) last=last.next;
                        head=head.next;
                        last.next=head;
                    }
                }else{
                    prev.next=curr.next;
                }
                System.out.println(key+" eliminado");
                return;
            }
            prev=curr;
            curr=curr.next;
        }while(curr!=head);
        System.out.println(key+" no encontrado");
    }
    public void deleteAtPosition(int index){
        if(head==null) return;

        Node curr=head, prev=null;
        int count=0;
        do{
            if(count==index){
                if(prev==null){
                    if(head.next==head){
                        head=null;
                    }else{
                        Node last=head;
                        while(last.next!=head) last=last.next;
                        head=head.next;
                        last.next=head;
                    }
                }else{
                    prev.next=curr.next;
                }
                System.out.println("Elemento en posicion "+index+" eliminado");
                return;
            }
            prev=curr;
            curr=curr.next;
            count++;
        }while(curr!=head);
        System.out.println("Posicion no valida");
    }
    public int size(){
        if(head==null) return 0;
        int count=0;
        Node temp=head;
        do{
            count++;
            temp=temp.next;
        }while(temp!=head);
        return count;
    }
    public void removeFirst(){
        deleteAtPosition(0);
    }
    public void removeLast(){
        deleteAtPosition(size()-1);
    }
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            head.next=head;
        }else{
            Node last=head;
            while(last.next!=head) last=last.next;
            newNode.next=head;
            head=newNode;
            last.next=head;
        }
    }
    public void addLast(int data){
        insert(data);
    }
}
