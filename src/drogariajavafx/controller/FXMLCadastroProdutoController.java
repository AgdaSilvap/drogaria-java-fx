
package drogariajavafx.controller;


import model.produto.ProdutoInsert;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class FXMLCadastroProdutoController implements Initializable {

    @FXML
    private TextField textFieldProduto;
    @FXML
    private DatePicker datePickerProdutoData;
    @FXML
    private TextField textFieldFabricante;
    @FXML
    private TextField textFieldPreco;
    @FXML
    private Button buttonSalvar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void handleButtonSalvar() {
        
        String nome_prod = textFieldProduto.getText();
        Date validade = java.sql.Date.valueOf(datePickerProdutoData.getValue());
        String fabricante = textFieldFabricante.getText();
        double preco = Double.parseDouble(String.valueOf(textFieldPreco.getText())); 
        
        if (validarEntradaDeDados()) {
        produtoInsert(nome_prod, validade, fabricante, preco);
        
        } 
    }
     
    //Validar entrada de dados para o cadastro
    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldProduto.getText() == null || textFieldProduto.getText().length() == 0) {
            errorMessage += "Nome de produto inválido!\n";
        }
        if (datePickerProdutoData.getValue() == null) {
            errorMessage += "Data inválida!\n";
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
