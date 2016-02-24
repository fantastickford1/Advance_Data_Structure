import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Karlos on 2/23/2016.
 */
public class Controller implements Initializable {

    @FXML
    TextField addField,deleteField,searchField;
    @FXML
    TextArea textArea;

    BinarySearchTree tree;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tree = new BinarySearchTree();
    }

    @FXML private void add(){
        try {
            tree.insert(Integer.parseInt(addField.getText()));
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("The type of data is no accepted");
            alert.setContentText("Write a correct type of data - Integer");
            alert.showAndWait();
        }
        textArea.appendText(addField.getText() + " data added to the tree \n");
        addField.setText("");
    }

    @FXML private void delete(){
        try {
            tree.delete(Integer.parseInt(deleteField.getText()));
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("The type of data is no accepted");
            alert.setContentText("Write a correct type of data - Integer");
            alert.showAndWait();
        }
        textArea.appendText(deleteField.getText() + " data deleted from the tree\n");
        deleteField.setText("");
    }

    @FXML private void search(){
        Node node = null;
        try {
            node = tree.search(tree.getRoot(),Integer.parseInt(searchField.getText()));
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("The type of data is no accepted");
            alert.setContentText("Write a correct type of data - Integer");
            alert.showAndWait();
        }
        if (node != null)
            textArea.appendText("The number " + searchField.getText() +  " exist in the tree\n");
        else
            textArea.appendText("The number " + searchField.getText() +  " doesn't exist in the tree\n");
        searchField.setText("");
    }

    @FXML private void isLeaf(){
        Node node = null;
        try {
            node = tree.search(tree.getRoot(),Integer.parseInt(searchField.getText()));
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("The type of data is no accepted");
            alert.setContentText("Write a correct type of data - Integer");
            alert.showAndWait();
        }
        if (node == null)
            textArea.appendText("The number " + searchField.getText() +  " doesn't exist in the tree\n");
        else {
            boolean isLeaf = tree.isLeaf(node);
            if (isLeaf)
                textArea.appendText("The number " + searchField.getText() + " is a leaf\n");
            else
                textArea.appendText("The number " + searchField.getText() + " is not a leaf\n");
        }
        searchField.setText("");
    }

    @FXML private void nodeHeight(){
        int height = 0;
        try {
            height = tree.getNodeHeight(tree.getRoot(),Integer.parseInt(searchField.getText()));
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("The type of data is no accepted");
            alert.setContentText("Write a correct type of data - Integer");
            alert.showAndWait();
        }
        textArea.appendText("The number " + searchField.getText() + " has " + height + " height\n");
        searchField.setText("");
    }

    @FXML private void isEmpty(){
        if (tree.isEmpty())
            textArea.appendText("The tree is empty\n");
        else
            textArea.appendText("The tree is not empty\n");
    }

    @FXML private void noNodes(){
        textArea.appendText("The tree has " + tree.getNodes() + " nodes\n");
    }

    @FXML private void treeHeight(){
        int we = tree.maxDepth(tree.getRoot())-1;
        textArea.appendText("The tree's height is: " + we + "\n");
    }

    @FXML private void inORDER(){
        textArea.appendText("The content of the tree is: " + tree.inOrder() + "\n" );
    }

}
