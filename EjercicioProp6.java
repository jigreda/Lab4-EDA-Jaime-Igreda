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
    // Insertar al final (similar a addLast)
    public ListaDoble2 insert(int data) {
        Node new_node=new Node(data);
        if(head==null) {
            head=new_node;
        } else {
            Node last=head;
            while(last.next!=null) last=last.next;
            last.next=new_node;
            new_node.prev=last;
        }
        return this;
    }
    // Imprimir la lista desde el head hasta el final
    public void printList() {
        Node curr=head;
        System.out.print("Lista doble: ");
        while(curr!=null) {
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
    // Eliminar nodo por dato
    public ListaDoble2 deleteByKey(int key) {
        Node curr=head;
        while(curr!=null && curr.data!=key) {
            curr=curr.next;
        }
        if(curr==null) {
            System.out.println(key+" no encontrado");
            return this;
        }
        if(curr.prev!=null) {
            curr.prev.next=curr.next;
        } else {
            // Borrar head
            head=curr.next;
        }
        if(curr.next!=null) {
            curr.next.prev=curr.prev;
        }
        System.out.println(key+" eliminado");
        return this;
    }
    // Eliminar nodo por posición (índice)
    public ListaDoble2 deleteAtPosition(int index) {
        if(index<0) {
            System.out.println("Posicion "+index+" no valida");
            return this;
        }
        Node curr=head;
        int count=0;
        while(curr!=null && count<index) {
            curr=curr.next;
            count++;
        }
        if(curr==null) {
            System.out.println("Posicion "+index+" no encontrada");
            return this;
        }
        if(curr.prev!=null) {
            curr.prev.next=curr.next;
        } else {
            // Borrar head
            head=curr.next;
        }
        if(curr.next!=null) {
            curr.next.prev=curr.prev;
        }
        System.out.println("Posicion "+index+" eliminada");
        return this;
    }
    // Tamaño de la lista
    public int size() {
        int count=0;
        Node curr=head;
        while(curr!=null) {
            count++;
            curr=curr.next;
        }
        return count;
    }
    // Eliminar primer nodo (head)
    public ListaDoble2 removeFirst() {
        if(head!=null) {
            head=head.next;
            if(head!=null) head.prev=null;
        }
        return this;
    }
    // Eliminar último nodo
    public ListaDoble2 removeLast() {
        if(head==null) return this;
        if(head.next==null) {
            head=null;
            return this;
        }
        Node curr=head;
        while(curr.next!=null) curr=curr.next;
        curr.prev.next=null;
        return this;
    }
    // Insertar al inicio
    public ListaDoble2 addFirst(int data) {
        Node new_node=new Node(data);
        if(head!=null) {
            new_node.next=head;
            head.prev=new_node;
        }
        head=new_node;
        return this;
    }
    // Insertar al final (igual que insert)
    public ListaDoble2 addLast(int data) {
        return insert(data);
    }
}
class Principal {
    public static void main(String[] args) {
        ListaDoble2 lista=new ListaDoble2(new int[]{1,2,3,4,5,6,7,8,9,10});
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("\n--- MENU LISTA DOBLEMENTE ENLAZADA ---");
            System.out.println("1. Insertar al final (addLast)");
            System.out.println("2. Insertar al inicio (addFirst)");
            System.out.println("3. Imprimir lista");
            System.out.println("4. Eliminar por dato");
            System.out.println("5. Eliminar por posicion");
            System.out.println("6. Tamanio de la lista");
            System.out.println("7. Eliminar primer nodo (removeFirst)");
            System.out.println("8. Eliminar ultimo nodo (removeLast)");
            System.out.println("9. Salir");
            System.out.print("Elige una opcion: ");
            opcion=sc.nextInt();
            switch(opcion) {
                case 1:
                    System.out.print("Ingrese valor para insertar al final: ");
                    int valFin=sc.nextInt();
                    lista.addLast(valFin);
                    System.out.println(valFin+" insertado al final");
                    break;
                case 2:
                    System.out.print("Ingrese valor para insertar al inicio: ");
                    int valIni=sc.nextInt();
                    lista.addFirst(valIni);
                    System.out.println(valIni+" insertado al inicio");
                    break;
                case 3:
                    lista.printList();
                    break;
                case 4:
                    System.out.print("Ingrese dato a eliminar: ");
                    int dato=sc.nextInt();
                    lista.deleteByKey(dato);
                    break;
                case 5:
                    System.out.print("Ingrese posicion a eliminar: ");
                    int pos=sc.nextInt();
                    lista.deleteAtPosition(pos);
                    break;
                case 6:
                    System.out.println("Tamanio de la lista: "+lista.size());
                    break;
                case 7:
                    lista.removeFirst();
                    System.out.println("Primer nodo eliminado");
                    break;
                case 8:
                    lista.removeLast();
                    System.out.println("Ultimo nodo eliminado");
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while(opcion!=9);
    }
}
