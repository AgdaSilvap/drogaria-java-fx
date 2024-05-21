
package drogariajavafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.produto.Produto;
import model.produto.ProdutoSelect;
import model.produto.ProdutoUpdate;
import model.produto.ProdutoDelete;

public class FXMLListaProdutosController implements Initializable {

   @FXML
    private ListView<Produto> listViewProduto;
   
   @FXML
    private Button buttonAlterar;
   
   @FXML
    private Label labelProduto;   
    @FXML
    private Label labelValidade;
    @FXML
    private Label labelFabricante;
    @FXML
    private Label labelPreco;
   
    private List<Produto> listProdutos;
    private ObservableList<Produto> observableListProdutos;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void carregarListViewProdutos() {
        listProdutos = ProdutoSelect.mainSelect();

        observableListProdutos = FXCollections.observableArrayList(listProdutos);
        listViewProduto.setItems(observableListProdutos);
    }

    public void selecionarItemListViewProduto(Produto produto) {
        if (produto != null) {
            labelProduto.setText(String.valueOf(produto.getNome()));
            labelValidade.setText(produto.getValidade());
            labelFabricante.setText(produto.getValidade());
            labelPreco.setText(String.valueOf(produto.getPreco()));
        } else {
            labelProduto.setText("");
            labelValidade.setText("");
            labelFabricante.setText("");
            labelPreco.setText("");
        }
    }
    
    @FXML
    public void handleButtonAlterar() throws IOException {
        Produto produto = listViewProduto.getSelectionModel().getSelectedItem();//Obtendo cliente selecionado
        if (produto != null) {
            boolean buttonConfirmarClicked = showFXMLAlterarProdutoDialog(produto);
            if (buttonConfirmarClicked) {
                ProdutoUpdate.mainUpdate();
                carregarListViewProdutos();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um produto da Lista!");
            alert.show();
        }
    }

    @FXML
    public void handleButtonRemover() throws IOException {
        Produto produto = listViewProduto.getSelectionModel().getSelectedItem();
        if (produto != null) {
            Integer id = produto.getId();
            ProdutoDelete.mainDelete(id);
            carregarListViewProdutos();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }
    
    public boolean showFXMLAlterarProdutoDialog(Produto produto) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAlterarProdutoDialogController.class.getResource("/drogariajavafx/view/FXMLAlterarProdutoDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Produtos");
        
        
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        FXMLAlterarProdutoDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setProduto(produto);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }
    
}
