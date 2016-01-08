import java.io.Serializable;

public class ArbolB implements Serializable{
    class Nodo implements Serializable
      {
        Customers info;
        Nodo izq, der;
      }
      Nodo raiz;
      private static final long serialVersionUID = 1;

      public ArbolB()
      {
          raiz=null;
      }

      public void insertar (Customers info)
      {
          Nodo nuevo;
          nuevo = new Nodo ();
          nuevo.info = info;
          nuevo.izq = null;
          nuevo.der = null;
          if (raiz == null)
              raiz = nuevo;
          else
          {
              Nodo anterior = null, reco;  //reco se utiliza en toso el programa para recorrer el arbol
              reco = raiz;
              while (reco != null)     // hasta encontrar un lugar vacio, respetando el orden
              {
                  anterior = reco;
                  if (info.compareTo(reco.info) < 0)
                      reco = reco.izq;
                  else
                      reco = reco.der;
              }
              if (info.compareTo(anterior.info) < 0)     // de acuerdo a si es mayor o menor se coloca a la izq o der
                  anterior.izq = nuevo;
              else
                  anterior.der = nuevo;
          }
      }


      private void preOrder (Nodo reco)
      {
          if (reco != null)
          {
              System.out.println(reco.info + " ");
              preOrder (reco.izq);
              preOrder (reco.der);
          }
      }

      public void preOrder ()
      {
          preOrder (raiz);
          System.out.println();
      }

      private void inOrder (Nodo reco)
      {
          if (reco != null)
          {
              inOrder (reco.izq);
              System.out.println(reco.info + " ");
              inOrder (reco.der);
          }
      }

      public void inOrder ()
      {
          inOrder (raiz);
          System.out.println();
      }


      private void postOrder (Nodo reco)
      {
          if (reco != null)
          {
              postOrder (reco.izq);
              postOrder (reco.der);
              System.out.println(reco.info + " ");
          }
      }


      public void postOrder ()
      {
          postOrder (raiz);
          System.out.println();
      }

      public void delete(){
        raiz=null;
      }
/*
      public static void main (String [] ar)
      {
          ArbolB abo = new ArbolB ();
          abo.insertar (100);
          abo.insertar (50);
          abo.insertar (25);
          abo.insertar (75);
          abo.insertar (150);
          System.out.println ("Impresion preOrder: ");
          abo.preOrder ();
          System.out.println ("Impresion inOrder: ");
          abo.inOrder ();
          System.out.println ("Impresion postOrder: ");
          abo.postOrder ();
      }*/
}
