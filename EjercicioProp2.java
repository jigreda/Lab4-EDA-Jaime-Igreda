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
    if(datos==null||datos.length==0)
      return null;
    Node<T> cabeza=new Node<>(datos[0]); //Primer nodo
    Node<T> actual=cabeza;
    for(int i=1;i<datos.length;i++) {
      Node<T> nuevo=new Node<>(datos[i]);
      actual.next=nuevo;
      actual=nuevo;
    }
    actual.next=cabeza; //Hacer la lista circular
      return cabeza;
  }
}
