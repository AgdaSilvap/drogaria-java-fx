
package drogariajavafx.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.venda.Venda;
import model.venda.VendaInsert;


public class FXMLCadastroVendaDialogController implements Initializable {

   @FXML
    private TextField textFieldProduto;
    @FXML
    private DatePicker datePickerVendaData;
    @FXML
    private TextField textFieldValor;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    private Stage dialogStage;
    boolean buttonConfirmarClicked = false;
   
    private Venda venda;
    
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

    public Venda getVenda() {
        return this.venda;
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }
    
    @FXML
    public void handleButtonConfirmar() {
        String nome_prod = textFieldProduto.getText();
        String data_venda = String.valueOf(datePickerVendaData.getValue());
        double preco = Double.parseDouble(String.valueOf(textFieldValor.getText())); 
        
        if (validarEntradaDeDados()) {
        VendaInsert.mainInsert(nome_prod, data_venda, preco);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro de Vendas");
        alert.setHeaderText("Venda Cadastrada!");
        alert.setContentText("A venda inserida foi cadastrada com sucesso!");
        alert.show();
        
        dialogStage.close();
        buttonConfirmarClicked = true;
     }
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
        if (datePickerVendaData == null ) {
            errorMessage += "Data inválida!\n";
        }
        if (textFieldValor.getText() == null || textFieldValor.getText().length() == 0) {
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
