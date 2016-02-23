public class BinarySearchTree{
    Node root;
    private int cont = 0;
    private int nodeHeight;
    private int height = 0;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(int data){
        Node newNode;
        newNode = new Node(data);
        if (root == null) {
            root = newNode;
            cont++;
        }else {
            Node last = null, reco;
            reco = root;
            while(reco != null){
                last = reco;
                if (data < reco.info)
                    reco = reco.left;
                else
                    reco = reco.right;
            }
            if (data < last.info) {
                cont++;
                last.left = newNode;
            }else{
                cont++;
                last.right = newNode;
            }
        }
    }

    public boolean delete(int data){
        if (root != null){
            Node parent = null;
            Node current = root;
            boolean isLeftChild = false;
            while (current.info != data){
                parent = current;
                if (data < current.info) {
                    isLeftChild = true;
                    current = current.left;
                }else {
                    isLeftChild = false;
                    current = current.right;
                }
                if (current == null)
                    return false;

            }
            //The node to delete is a leaf
            if (isLeaf(current)){
                if (current == root) {
                    root = null;
                    cont = 0;
                }if (isLeftChild == true)
                    parent.left = null;
                else
                    parent.right = null;
            }
            //The node to delete is a branch
            else if (current.right == null){
                if (current == root)
                    root = current.left;
                else if (isLeftChild)
                    parent.left = current.left;
                else
                    parent.right = current.left;
            }else if (current.left == null){
                if (current == root){
                    root = current.right;
                }else if (isLeftChild)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }else if (!isLeaf(current)){
                //The branch has two childs
                Node succssor = getSuccesor(current);
                if (current == root)
                    root = succssor;
                else if (isLeftChild)
                    parent.left = succssor;
                else
                    parent.right = succssor;
                succssor.left = current.left;
            }
            cont--;
            return true;
        }
        return false;
    }

    private Node getSuccesor(Node deleteNode){
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.right;
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != deleteNode.right){
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }

    public Node search(Node node, int data){
        if (node == null || node.info == data)
            return node;
        else if (data < node.info)
            return search(node.left, data);
        else
            return search(node.right, data);
    }

    public boolean isLeaf(Node node){
        return (node.left == null && node.right == null);
    }

    public Node getRoot(){
        return root;
    }

    public boolean isEmpty(){
        if (root == null || cont == 0)
            return true;
        else return false;
    }

    public int getNodes(){
        return cont;
    }

    public int getNodeHeight(Node node, int id){
        nodeHeight = 0;
        return nodeHeight(node,id);
    }

    private int nodeHeight(Node node, int id){
        if (node == null || node.info == id)
            return nodeHeight;
        else if (id < node.info){
            nodeHeight++;
            nodeHeight(node.left, id);
        }else{
            nodeHeight++;
            nodeHeight(node.right, id);
        }
        return nodeHeight;
    }

    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }
}
