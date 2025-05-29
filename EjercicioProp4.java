import java.util.LinkedList;
import java.util.ListIterator;
public class ListaCircularUtil {
  public static void main(String[] args) {
    //Crear una lista enlazada (LinkedList)
    LinkedList<Integer> lista=new LinkedList<>();
    //Agregar los elementos del 1 al 12
    for(int i=1;i<=12;i++){
      lista.add(i);
    }
    //Imprimir la lista circular (una vuelta completa)
    System.out.println("Lista circular:");
    System.out.println(lista);
    ListIterator<Integer> it=lista.listIterator(); //Iterador de la lista
    int contador=0, tam=lista.size();
    while(contador<tam){ //Recorremos exactamente una vuelta
      if(it.hasNext()){
        System.out.print(it.next()+" ");
      }else{
        it=lista.listIterator(); //Reinicio del iterador al inicio (simula circularidad)
        System.out.print(it.next()+" ");
      }
      contador++;
    }
    System.out.println();
  }
}
