
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.venda.Venda;
import model.venda.VendaDelete;
import model.venda.VendaInsert;
import model.venda.VendaSelect;


public class FXMLProcessoVendasController implements Initializable {

    @FXML
    private TableView<Venda> tableViewVendas;
    @FXML
    private TableColumn<Venda, Integer> tableColumnVendaCodigo;
    
    @FXML
    private TableColumn<Venda, Venda> tableColumnVendaProduto;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonRemover;
    @FXML
    private Label labelVendaCodigo;
    @FXML
    private Label labelVendaProduto;
    @FXML
    private Label labelVendaData;
    @FXML
    private Label labelVendaValor;
    
    

    private List<Venda> listVendas;
    private ObservableList<Venda> observableListVendas;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        carregarTableViewVendas();

        // Limpando a exibição dos detalhes da venda
        selecionarItemTableViewVendas(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tableViewVendas.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewVendas(newValue));
        
    }

    public void carregarTableViewVendas() {
        tableColumnVendaCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnVendaProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));

        listVendas = VendaSelect.mainSelect();

        observableListVendas = FXCollections.observableArrayList(listVendas);
        tableViewVendas.setItems(observableListVendas);
    }

    public void selecionarItemTableViewVendas(Venda venda) {
        if (venda != null) {
            labelVendaCodigo.setText(String.valueOf(venda.getId()));
            labelVendaProduto.setText(venda.getProduto());
            labelVendaData.setText(venda.getData());
            labelVendaValor.setText(String.format("%.2f", venda.getValor()));
            
        } else {
            labelVendaCodigo.setText("");
            labelVendaProduto.setText("");
            labelVendaData.setText("");
            labelVendaValor.setText("");
        }
    }

    @FXML
    public void handleButtonInserir() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLCadastroVendaDialogController.class.getResource("/drogariajavafx/view/FXMLCadastroVendaDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Registro de Vendas");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        FXMLCadastroVendaDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();
        
        if(controller.isButtonConfirmarClicked()){
            carregarTableViewVendas();
        }
        
    }


    @FXML
    public void handleButtonRemover() throws IOException {
        Venda venda = tableViewVendas.getSelectionModel().getSelectedItem();
        if (venda != null) {
            Integer id = venda.getId();
            VendaDelete.mainDelete(id);
            carregarTableViewVendas();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha uma venda na Tabela!");
            alert.show();
        }
    }
   
    
}
