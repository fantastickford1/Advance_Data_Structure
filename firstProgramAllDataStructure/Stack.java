public class Stack<T>{

  private T pila[];
  private int tope;

  public Stack(int capacidad){
    pila = new T[capacidad];
    tope = -1;
  }

  public boolean isEmpty(){
    return tope == -1;
  }

  public void push(T i){
    if (tope+1 < pila.length)
      pila[++tope] = i;
  }

  public T pop(){
    if(isEmpty())
      return 0;
    return pila[tope--];
  }

}
