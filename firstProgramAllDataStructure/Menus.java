import java.util.Scanner;

public class Menus{

    Scanner keybord;
    ListaSimple<String> ls;
    DoublyLinkedList<String> ld;
    MyQueue<String> cola;
    Stack<String> pila;
    ArbolB arbol;
    int size;
    int pos;
    String dato;

    Menus(){
      ls = new ListaSimple<>();
      ld = new DoublyLinkedList<>();
      arbol = new ArbolB();
      keybord= new Scanner(System.in);
    }

   public void MenuPrincipal(){
     System.out.println("BIENVENIDOS");
     System.out.println("Instrucciones: Elija una opcion dependiendo la estructura que desea.");
     System.out.println("1. Lista Simple");
     System.out.println("2. Lista Doblemente Enlazada");
     System.out.println("3. Cola");
     System.out.println("4. Pila");
     System.out.println("5. Arbol Binario");
     System.out.println("6. Salir");
     String opc= keybord.next();

     switch (opc) {
       case "1":
        menuListaS();
        MenuPrincipal();
      break;
       case "2":
        menuListaDoble();
        MenuPrincipal();
       break;
       case "3":
        System.out.println("Ingrese el tamaño de la cola:");
        size = keybord.nextInt();
        cola = new MyQueue<>(size);
        menuCola();
        MenuPrincipal();
       break;
       case "4":
        System.out.println("Ingrese el tamaño de la pila:");
        size = keybord.nextInt();
        pila = new Stack<>(size);
        menuPila();
        MenuPrincipal();
       break;
       case "5":
       menuArbol();
       MenuPrincipal();
       break;
       case "6":
         break;
       default:
        System.out.println("Error: opcion no valida");
        MenuPrincipal();
       break;
     }
   }

   private void menuListaS(){
     System.out.println("------Lista Simple---------");
     System.out.println("Que desea hacer?");
     System.out.println("1. agregar a la lista");
     System.out.println("2. obtener un valor de la lista en la posicion indicada");
     System.out.println("3. remover elemento en la posición indicada");
     System.out.println("4. agregar un elemento en la posición indicada");
     System.out.println("5. conocer el tamaño de la lista");
     System.out.println("6. ver lista simple");
     System.out.println("7. Regresar al menu principal");
     String opc1= keybord.next();
     switch (opc1) {
       case "1":
         System.out.println("ingrese el dato a agregar");
         String dato= keybord.next();
         ls.add(dato);
         menuListaS();
       break;
       case "2":
         System.out.println("Ingrese una posicion para obtener un dato");
         pos= keybord.nextInt();
         System.out.println(ls.get(pos).getData());
         menuListaS();
       break;
       case "3":
         System.out.println("Ingrese una posicion para remover el dato");
         pos= keybord.nextInt();
         ls.remove(pos);
         menuListaS();
       break;
       case "4":
         System.out.println("Ingrese una posicion");
         pos= keybord.nextInt();
         System.out.println("ingrese un dato a agregar");
         dato= keybord.next();
         ls.addPos(pos, dato);
         menuListaS();
       break;
       case "5":
        System.out.println("El tamaño de su lista es de: ");
        System.out.println(ls.size());
        menuListaS();
       break;
       case "6":
        System.out.println("Esta es su lista: ");
        System.out.println(ls.toString());
        menuListaS();
       break;
       case "7":
        break;
       default:
        System.out.println("Error: opcion no valida");
        menuListaS();
     }
   }

   public void menuListaDoble(){
     System.out.println("------Lista Doblemente Enlazada---------");
     System.out.println("Que desea hacer?");
     System.out.println("1. agregar a la lista doble");
     System.out.println("2. obtener un valor de la lista en la posicion indicada");
     System.out.println("3. remover elemento en la posición indicada");
     System.out.println("4. conocer el tamaño de la lista");
     System.out.println("5. agregar una dato en una posicion indicada");
     System.out.println("6. ver lista de forma ascendente");
     System.out.println("7. ver lista de forma descendente");
     System.out.println("8. Regresar al menu principal");
     String opc2= keybord.next();
     switch (opc2) {
       case "1":
         System.out.println("ingrese el dato a agregar");
         String dato= keybord.next();
         ld.add(dato);
         menuListaDoble();
       break;
       case "2":
         System.out.println("Ingrese una posicion para obtener un dato");
         pos= keybord.nextInt();
         System.out.println(ld.get(pos));
         menuListaDoble();
       break;
       case "3":
         System.out.println("Ingrese una posicion para remover el dato");
         pos= keybord.nextInt();
         ld.remove(pos);
         menuListaDoble();
      break;
      case "4":
        System.out.println("El tamaño de su lista es de: ");
        System.out.println(ld.size());
        menuListaDoble();
      break;
      case "5":
        System.out.println("Ingrese una posicion");
        pos= keybord.nextInt();
        System.out.println("ingrese un dato a agregar");
        dato= keybord.next();
        ld.addPos(pos, dato);
        menuListaDoble();
      break;
      case "6":
        System.out.println("Lista Doblemente Enlazada Ascendente: ");
        ld.iterateForward();
      break;
      case "7":
        System.out.println("Lista Doblemente Enlazada Descendente: ");
        ld.iterateBackward();
      break;
      case "8":
      break;
     default:
      System.out.println("Error: opcion no valida");
      menuListaDoble();
     }
   }

   public void menuCola(){
     System.out.println("------Cola---------");
     System.out.println("Que desea hacer?");
     System.out.println("1. Insertar un dato");
     System.out.println("2. remover: remueve y regresa el dato siguiente");
     System.out.println("3. mostrar el dato siguiente");
     System.out.println("4. Saber si esta vacia o no la cola: regresa un valor boleano");
     System.out.println("5. tamaño de la cola");
     System.out.println("6. Regresar al menu principal");
     String opc3= keybord.next();
     switch (opc3) {
       case "1":
         System.out.println("ingrese el dato a agregar");
         String dato= keybord.next();
         try {
           cola.enqueue(dato);
         }catch (Exception e) {
           System.out.println(e.getMessage());
         }
         menuCola();
       break;
       case "2":
         System.out.println("Se removera un elemento");
         try {
           System.out.println(cola.dequeue());
         }catch (Exception e) {
           System.out.println(e.getMessage());
         }
         System.out.println("Elemento removido exitosamente!");
         menuCola();
       break;
       case "3":
        System.out.println("el elemento siguiente es: ");
        try {
          System.out.println(cola.peek());
        }catch (Exception e) {
          System.out.println(e.getMessage());
        }
       break;
       case "4":
          System.out.println("la cola esta vacia? ");
          System.out.println(cola.isEmpty());
       break;
       case "5":
         System.out.println("el tamaño de la cola es: ");
         System.out.println(cola.size());
       break;
       case "6":
       break;
       default:
        System.out.println("Error: opcion no valida");
        menuCola();
      break;
     }

   }

   public void menuPila(){
     System.out.println("------Pila--------");
     System.out.println("Que desea hacer?");
     System.out.println("1. Insertar un dato");
     System.out.println("2. remover: remueve el ultimo dato");
     System.out.println("3. Regresar al menu principal");
     String opc4= keybord.next();
     switch (opc4) {
       case "1":
         System.out.println("ingrese el dato a agregar");
         String dato= keybord.next();
         pila.push(dato);
         menuPila();
       break;
       case "2":
         System.out.println("Se removera un ultimo elemento agregado");
         System.out.println(pila.pop());
         System.out.println("Elemento removido exitosamente!");
         menuPila();
       break;
       case "3":
       break;
     }

   }

   public void menuArbol(){
     System.out.println("------Arbol Binario (String)--------");
     System.out.println("Que desea hacer?");
     System.out.println("1. Insertar un dato");
     System.out.println("2. Recorrer el arbol");
     System.out.println("3. Eliminar arbol");
     System.out.println("4. Regresar al menu principal");
     String opc4= keybord.next();
     switch (opc4) {
       case "1":
        String data = keybord.nextLine();
        arbol.insertar(data);
        menuArbol();
        break;
       case "2":
        System.out.println("Recorrido preOrder:");
        arbol.preOrder();
        System.out.println("Recorrido inOrder");
        arbol.inOrder();
        System.out.println("Recorrido postOrder");
        arbol.postOrder();
        menuArbol();
        break;
       case "3":
        arbol.delete();
        menuArbol();
        break;
       case "4":
        break;
       default:
        menuArbol();
        break;
     }
   }



}
