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
  //Metodo para imprimir la lista circular una sola vez
    public void imprimirLista(Node<T> cabeza) {
        if(cabeza==null)return;
        System.out.println("Lista circular:");
        Node<T> actual=cabeza;
        do {
            System.out.print(actual.data+" ");
            actual=actual.next;
        } while(actual!=cabeza);

        System.out.println();
    }
    //Metodo principal para probar con enteros
    public static void main(String[] args) {
        ListaCircular<Integer> lista=new ListaCircular<>();
        Integer[] datos={1,2,3,4,5,6,7,8,9,10,11,12};
        Node<Integer> cabeza=lista.crearListaCircular(datos);
        lista.imprimirLista(cabeza);
    }
}
