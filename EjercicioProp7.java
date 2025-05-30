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
class Principal {
    public static void main(String[] args){
        ListaCircular2 lista=new ListaCircular2();
        for(int i=1;i<=12;i++) lista.insert(i);
        Scanner sc=new Scanner(System.in);
        int opcion,valor,pos;
        do{
            System.out.println("-MENU LISTA CIRCULAR-");
            System.out.println("\n1. Insertar");
            System.out.println("2. Imprimir Lista");
            System.out.println("3. Eliminar por valor");
            System.out.println("4. Eliminar por posicion");
            System.out.println("5. Tamano");
            System.out.println("6. Eliminar primero");
            System.out.println("7. Eliminar ultimo");
            System.out.println("8. Agregar al inicio");
            System.out.println("9. Agregar al final");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.print("Valor: ");
                    valor=sc.nextInt();
                    lista.insert(valor);
                    break;
                case 2:
                    lista.printList();
                    break;
                case 3:
                    System.out.print("Valor: ");
                    valor=sc.nextInt();
                    lista.deleteByKey(valor);
                    break;
                case 4:
                    System.out.print("Posicion: ");
                    pos=sc.nextInt();
                    lista.deleteAtPosition(pos);
                    break;
                case 5:
                    System.out.println("Tamano: "+lista.size());
                    break;
                case 6:
                    lista.removeFirst();
                    break;
                case 7:
                    lista.removeLast();
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
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while(opcion!=0);
    }
}
