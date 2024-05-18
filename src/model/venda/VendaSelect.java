package model.venda;
import dao.VendaDAO;
import java.util.List;

public class VendaSelect {
   public static List<Venda> mainSelect() {
        VendaDAO vendaDAO = new VendaDAO();
        List<Venda> lista = vendaDAO.listar();
        return lista;
    } 
}