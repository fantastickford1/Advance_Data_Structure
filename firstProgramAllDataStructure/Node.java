public class Node <T>{
    //Referencia al siguiente elemento o a NULL si es el ultimo
    Node<T> forward;
    Node<T> backward;
    T data;
    // Node constructor
    public Node(T dataValue) {
        forward = null;
        backward = null;
        data = dataValue;
    }
    // Constructor que incluye el siguiente nodo
    public Node(T dataValue, Node<T> nextValue, Node<T> lastValue) {
        forward = nextValue;
        backward = lastValue;
        data = dataValue;
    }

    public T getData() {
        return data;
    }

    public void setData(T dataValue) {
        data = dataValue;
    }

    public Node<T> getNext() {
        return forward;
    }

    public Node<T> getLast(){
      return backward;
    }

    public void setNext(Node<T> nextValue) {
      forward = nextValue;
    }

    public void setLast(Node<T> lastValue){
      backward = lastValue;
    }
}
