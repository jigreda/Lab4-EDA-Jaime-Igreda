public class ListaDoble {
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
  //Metodo que crea una lista doblemente enlazada 
  public static Node crearLista(int inicio,int fin) {
    if(inicio>fin)
      return null; // Caso inválido
    Node head=new Node(inicio); // Primer nodo (cabeza)
    Node actual=head;
    //Crear los siguientes nodos y enlazarlos
    for(int i=inicio+1;i<=fin;i++) {
      Node nuevo=new Node(i); //Crear nuevo nodo
      actual.next=nuevo; //Enlazar el actual con el nuevo hacia adelante
      nuevo.prev=actual; //Enlazar el nuevo con el actual hacia atrás
      actual=nuevo; //Avanzar al nuevo nodo
    }
    return head; //Retornar la cabeza de la lista
  }
  public static void main(String[] args) {
    Node head=crearLista(1,10);
  }
}
