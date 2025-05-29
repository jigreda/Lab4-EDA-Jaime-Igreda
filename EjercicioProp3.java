package lab4.eda;
import java.util.LinkedList;
public class ListaDobleUtil<T>{
  public static void main(String[] args){
    // Crear la lista doblemente enlazada usando LinkedList
    LinkedList<Integer> lista=new LinkedList<>();
    // Agregar los elementos del 1 al 10
    for(int i=1;i<=10;i++)
        lista.add(i);
    // Imprimir lista hacia adelante
    System.out.println("Imprimir Lista hacia adelante");
    System.out.println(lista);
    // Imprimir lista hacia atrás usando un bucle inverso
    System.out.println("Lista hacia atras:");
    System.out.print("[");
    for(int i=lista.size()-1;i>=0;i--)
      System.out.print(lista.get(i)+" ");
    System.out.println("]");
  }
}
