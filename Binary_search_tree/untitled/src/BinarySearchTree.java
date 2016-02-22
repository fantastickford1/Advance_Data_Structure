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
    public boolean delete(int data){
        if(root == null)
            return false;
        else {
            Node lastNode = null, reco;
            reco = root;
            while (reco != null){
                lastNode = reco;
                if (data < reco.info) {
                    reco = reco.left;
                    if (reco.info == data){
                        if (isLeaf(reco)){
                            lastNode.left = null;
                            return true;
                        }
                        if (reco.left == null){
                            lastNode = reco;
                            reco = reco.right;
                            lastNode.info = reco.info;
                            lastNode.right = null;
                            return true;
                        }else if (reco.right == null){
                            lastNode = reco;
                            reco = reco.left;
                            lastNode.info = reco.info;
                            lastNode.left = null;
                            return true;
                        }
                    }
                }else {
                    reco = reco.right;
                    if (reco.info == data){
                        if (isLeaf(reco)){
                            lastNode.right = null;
                            return true;
                        }
                        if (reco.left == null){
                            lastNode = reco;
                            reco = reco.right;
                            lastNode.info = reco.info;
                            lastNode.right = null;
                            return true;
                        }else if (reco.right == null){
                            lastNode = reco;
                            reco = reco.left;
                            lastNode.info = reco.info;
                            lastNode.left = null;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
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

  public boolean isLeaf(Node node){
    return (node.left == null && node.right == null);
  }

  public Node getRoot(){
    return root;
  }
}
