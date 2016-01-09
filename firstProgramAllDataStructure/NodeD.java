public class NodeD <T>{
    //Referencia al siguiente elemento o a NULL si es el ultimo
    NodeD<T> forward;
    NodeD<T> backward;
    T data;
    // NodeD constructor
    public NodeD(T dataValue) {
        forward = null;
        backward = null;
        data = dataValue;
    }
    // Constructor que incluye el siguiente nodo
    public NodeD(T dataValue, NodeD<T> nextValue, NodeD<T> lastValue) {
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

    public NodeD<T> getNext() {
        return forward;
    }

    public NodeD<T> getLast(){
      return backward;
    }

    public void setNext(NodeD<T> nextValue) {
      forward = nextValue;
    }

    public void setLast(NodeD<T> lastValue){
      backward = lastValue;
    }
}
