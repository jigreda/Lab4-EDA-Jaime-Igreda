import java.util.Scanner;
public class ListaSimple {
  Node head;
  public ListaSimple insert(int data) {
    Node new_node=new Node(data);
    if(head==null) {
      head=new_node;
    } else {
      Node last=head;
      while(last.next!=null) 
        last=last.next;
      last.next=new_node;
    }
    return this;
  }
  public void printList() {
    Node curr=head;
    System.out.print("Lista: ");
    while(curr!=null) {
      System.out.print(curr.data+" ");
      curr=curr.next;
    }
    System.out.println();
  }
  public ListaSimple deleteByKey(int key) {
    Node curr=head, prev=null;
    if(curr!=null && curr.data==key) {
      head=curr.next;
      System.out.println(key+" eliminado");
      return this;
    }
    while(curr!=null && curr.data!=key) {
      prev=curr;
      curr=curr.next;
    }
    if(curr!=null) {
      prev.next=curr.next;
      System.out.println(key+" eliminado");
    } else {
      System.out.println(key+" no encontrado");
    }
    return this;
  }
  public ListaSimple deleteAtPosition(int index) {
    if(index<0) 
      return this;
    Node curr=head, prev=null;
    if(index==0 && curr!=null) {
      head=curr.next;
      System.out.println("Posicion "+index+" eliminada");
      return this;
    }
    int count=0;
    while(curr!=null) {
      if(count==index) {
        prev.next=curr.next;
        System.out.println("Posicion "+index+" eliminada");
        return this;
      }
      prev=curr;
      curr=curr.next;
      count++;
    }
    System.out.println("Posicion "+index+" no encontrada");
    return this;
  }
}
class Node{
    int data;
    Node next;
    Node(int d) {
        data=d;
        next=null;
    }
}
