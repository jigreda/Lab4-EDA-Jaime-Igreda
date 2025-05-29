public class ListaCircular<T> {
  //Clase interna Node genérica
  static class Node<T> {
    T data; //Dato de tipo genérico
    Node<T> next; //Referencia al siguiente nodo
    Node(T d) {
      data=d;
      next=null;
    }
  }
  public Node<T> crearListaCircular(T[] datos) {
    
  }
