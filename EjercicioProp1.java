public class ListaDoble<T> {
    //Clase interna Node genérica
    static class Node<T> {
        T data; //Dato de tipo genérico
        Node<T> next; //Referencia al siguiente nodo
        Node<T> prev; //Referencia al nodo anterior
        Node(T d){
            data=d;
            next=null;
            prev=null;
        }
    }
    //Metodo que crea una lista doblemente enlazada con un arreglo de datos
    public Node<T> crearLista(T[] datos) {
        if(datos==null||datos.length==0)return null;
        Node<T> cabeza=new Node<>(datos[0]);
        Node<T> actual=cabeza;
        for(int i=1;i<datos.length;i++) {
            Node<T> nuevo=new Node<>(datos[i]);
            actual.next=nuevo;
            nuevo.prev=actual;
            actual=nuevo;
        }
        return cabeza;
    }
    // Metodo para imprimir la lista desde el inicio hacia el final
    public void imprimirAdelante(Node<T> cabeza) {
        System.out.println("Lista hacia adelante:");
        Node<T> temp=cabeza;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
  public static void main(String[] args) {
    ListaDoble<Integer> lista=new ListaDoble<>();
    Integer[] datos={1,2,3,4,5,6,7,8,9,10};
    Node<Integer> cabeza=lista.crearLista(datos);
    lista.imprimirAdelante(cabeza);
  }
}
