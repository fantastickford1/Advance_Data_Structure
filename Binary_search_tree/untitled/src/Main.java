/**
 * Created by Karlos on 2/20/2016.
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(38);
        tree.insert(70);
        tree.insert(47);
        tree.insert(57);
        tree.insert(48);
        tree.insert(54);
        tree.insert(45);
        tree.insert(59);
        tree.insert(80);
        tree.insert(44);
        Node node = tree.search(tree.getRoot(),80);
        if (node == null)
            System.out.println("Cant find the data");
        else
            System.out.println(node.info);
        tree.delete(45);
    }
}
