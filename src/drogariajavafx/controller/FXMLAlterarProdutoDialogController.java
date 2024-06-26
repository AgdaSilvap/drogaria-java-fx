
package drogariajavafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.produto.Produto;


public class FXMLAlterarProdutoDialogController implements Initializable {
    @FXML
    private Label labelProduto;
    @FXML
    private Label labelFabricante;
    @FXML
    private Label labelPreco;
    @FXML
    private TextField textFieldProduto;
    @FXML
    private TextField textFieldFabricante;
    @FXML
    private TextField textFieldPreco;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Produto produto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        this.textFieldProduto.setText(produto.getNome());
        this.textFieldFabricante.setText(produto.getFabricante());
        this.textFieldPreco.setText(String.valueOf(produto.getPreco()));
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    @FXML
    public Produto handleButtonConfirmar() {
        if (validarEntradaDeDados()) {
            produto.setNome(textFieldProduto.getText());
            produto.setFabricante(textFieldFabricante.getText());
            produto.setPreco(Double.parseDouble(textFieldPreco.getText()));

            buttonConfirmarClicked = true;
            dialogStage.close();
        }
        return null;
    }

    @FXML
    public void handleButtonCancelar() {
        getDialogStage().close();
    }

    //Validar entrada de dados para o cadastro
     private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldProduto.getText() == null || textFieldProduto.getText().length() == 0) {
            errorMessage += "Nome de produto inválido!\n";
        }
        if (textFieldFabricante.getText() == null || textFieldFabricante.getText().length() == 0) {
            errorMessage += "Fabricante inválido!\n";
        }
        if (textFieldPreco.getText() == null || textFieldPreco.getText().length() == 0) {
            errorMessage += "Preço inválido!\n";
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
}
