// void enqueue( obj ) --> Inserta objeto
// Object dequeue( ) --> Remueve y regresa el siguiente elemento
// Object peek( ) --> Muestra el siguiente elemento sin alterar la estructura
// boolean isEmpty( ) --> true si está vacia; false si tiene elementos
// int size() --> Implementar: Cantidad de elementos en la estructura

public class MyQueue <T>{

  private int size;
  private T data[];
  private int index;

  public MyQueue(int s){
    this.size = s;
    data = new T[s];
  }

  public boolean isEmpty(){
    return index==0;
  }

  public void enqueue(T obj) throws Exception{
    if(index==size-1){
      throw new Exception("Queue is full. Dequeue some objects");
    }
    this.data[index]=obj;
    this.index++;
  }

  public T dequeue() throws Exception{
    if(isEmpty())throw new Exception("Queue is empty");
    T obj=this.data[0];
    for(int i =0; i<this.index-1; i++){
      data[i]=data[i+1];
    }
    this.index--;
    return obj;
  }

  public T peek() throws Exception{
    if(isEmpty())throw new Exception("Queue is empty");
    return this.data[0];
  }

  public int size(){
    return this.index;
  }

}
