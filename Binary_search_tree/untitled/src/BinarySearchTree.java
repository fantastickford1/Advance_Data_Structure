public class BinarySearchTree{
  Node root;

  public BinarySearchTree(){
    root = null;
  }

  public void insert(int data){
    Node newNode;
    newNode = new Node(data);
    if (root == null) {
      root = newNode;
    }else {
      Node last = null, reco;
      reco = root;
      while(reco != null){
        last = reco;
        if (data < reco.info) {
          reco = reco.left;
        }else{
          reco = reco.right;
        }
      }
      if (data < last.info) {
        last.left = newNode;
      }else {
        last.right = newNode;
      }
    }
  }

  public Node search(Node node, int data){
    if (node == null || node.info == data) {
      return node;
    }else if (data < node.info) {
      return search(node.left, data);
    }else {
      return search(node.right, data);
    }
  }

  public boolean delete(Node node, int data){
    Node aux;
    if (node == null)
      return false;
    if (data < node.info) {
      delete(node.left, data);
    }else if (data > node.info) {
      delete(node.right, data);
    }else if (node.info == data) {
      aux = node;
      if (isLeaf(node)) {
        node = null;
        return true;
      }
      if (node.right == null) {
        node = node.left;
        return true;
      }else if (node.left == null) {
        node = node.right;
        return true;
      }else {
        return true;
      }
    }
    return false;
  }

  private void replace(){

  }

  public boolean isLeaf(Node node){
    return (node.left == null && node.right == null);
  }

  public Node getRoot(){
    return root;
  }
}
