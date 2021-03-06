public class ListaSimple<T>{
    // Referencia  a el node raiz o la cabeza de la lista.
    private NodeS<T> head;
    private int listCount;

    // constructor
    public ListaSimple() {
        // Se asigna la cabeza a un nodo nulo y el contador a 0
        head = new NodeS<>(null);
        listCount = 0;
    }

    public void add(T data)
    // Agrega el nodo al final de la lista.
    {
        NodeS<T> Temp = new NodeS<>(data);
        NodeS<T> Current = head;
        // Se tiene que posicionar en la cabeza para poder recorrer la lista y llegar al fin
        while (Current.getNext() != null) {
            Current = Current.getNext();
        }
        // Asignamos el nuevo nodo como "next"
        Current.setNext(Temp);
        listCount++;// incrementamos el contador de nodos
    }

     public NodeS<T> get(int index)
    // Regresa el nodo en la posición indicada por index
    {
        if (index <= 0)
            return null;

        NodeS<T> Current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return null;
             Current = Current.getNext();
        }
        return Current;
    }

    public boolean remove(int index)
    // remueve el elemento en la posición indicada
    {
        //
        if (index < 1 || index > size())
            return false;
        NodeS<T> Current = head;
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return false;
             Current = Current.getNext();
        }
        Current.setNext(Current.getNext().getNext());
        listCount--; // disminuimos el contador de nodos
        return true;
    }

    public boolean addPos(int index, T data)
    // agrega el elemento en la posición indicada
    {
        //
        if (index < 1 )
            return false;
        if (index > size()){
            add(data);
            return true;
        }
        NodeS<T> Current = head;
        int a=index+1;
        for (int i = 1; i < index; i++) {
             Current = Current.getNext();
        }
        NodeS<T> Temp = new NodeS<>(data,Current.getNext());
        Current.setNext(Temp);
        listCount++; // aumenta  el contador de nodos
        return true;
    }

    public <Object extends Comparable<Object>> boolean addOrdenado(T data)
    // agrega el elemento en la posición indicada
    {
        NodeS<T> Current = head;
        int a=1;
        Object data1 = (Object) data;
        while(Current.getNext()!=null && data1.compareTo((Object)Current.getNext().getData()) > 0) {
          Current = Current.getNext();
          a++;
        }
        return addPos(a,data);
    }

    public int size()
    // returns the number of elements in this list.
    {
        return listCount;
    }

    public String toString()
    {
        NodeS<T> Current = head.getNext();
        String output = "";
        while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current = Current.getNext();
        }
        return output;
    }

}
