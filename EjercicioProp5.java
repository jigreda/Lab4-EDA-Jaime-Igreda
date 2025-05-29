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
  public int size() {
    int count=0;
    Node curr=head;
    while(curr!=null) {
      count++;
      curr=curr.next;
    }
    return count;
  }
  public ListaSimple removeFirst() {
    if(head!=null) {
      head=head.next;
    }
    return this;
  }
  public ListaSimple removeLast() {
        if(head==null || head.next==null) {
            head=null;
        } else {
            Node curr=head;
            while(curr.next.next!=null) curr=curr.next;
            curr.next=null;
        }
        return this;
    }
    public ListaSimple addFirst(int data) {
        Node new_node=new Node(data);
        new_node.next=head;
        head=new_node;
        return this;
    }
    public ListaSimple addLast(int data) {
        return insert(data);
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
class Principal {
    public static void main(String[] args) {
        ListaSimple lista=new ListaSimple(new int[]{1,2,3,4,5,6,7,8,9,10});
        Scanner sc=new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Insertar (al final)");
            System.out.println("2. Imprimir lista");
            System.out.println("3. Eliminar por clave");
            System.out.println("4. Eliminar por posicion");
            System.out.println("5. Tamanio de la lista");
            System.out.println("6. Eliminar primero");
            System.out.println("7. Eliminar ultimo");
            System.out.println("8. Agregar al inicio");
            System.out.println("9. Agregar al final");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion=sc.nextInt();
            int valor,pos;
            switch(opcion) {
                case 1:
                    System.out.print("Valor: ");
                    valor=sc.nextInt();
                    lista.insert(valor);
                    break;
                case 2:
                    lista.printList();
                    break;
                case 3:
                    System.out.print("Valor a eliminar: ");
                    valor=sc.nextInt();
                    lista.deleteByKey(valor);
                    break;
                case 4:
                    System.out.print("Posicion: ");
                    pos=sc.nextInt();
                    lista.deleteAtPosition(pos);
                    break;
                case 5:
                    System.out.println("Tamanio: "+lista.size());
                    break;
                case 6:
                    lista.removeFirst();
                    System.out.println("Primer nodo eliminado");
                    break;
                case 7:
                    lista.removeLast();
                    System.out.println("Ultimo nodo eliminado");
                    break;
                case 8:
                    System.out.print("Valor: ");
                    valor=sc.nextInt();
                    lista.addFirst(valor);
                    break;
                case 9:
                    System.out.print("Valor: ");
                    valor=sc.nextInt();
                    lista.addLast(valor);
                    break;
                case 0:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while(opcion!=0);
        sc.close();
    }
}
