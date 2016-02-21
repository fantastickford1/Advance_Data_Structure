/**
 * Created by Karlos on 2/20/2016.
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(52);
        tree.insert(95);
        tree.insert(42);
        tree.insert(32);
        tree.insert(100);
        tree.insert(31);
        tree.insert(48);
        tree.insert(82);
        tree.insert(158);
        tree.insert(47);
        Node node = tree.search(tree.getRoot(),48);
        System.out.println(node.info);
        boolean sd = tree.delete(tree.getRoot(),31);
        System.out.println(sd);
    }
}
