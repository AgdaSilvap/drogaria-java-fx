import dao.VendaDAO;
import java.sql.Date;
import model.venda.Venda;

public class VendaInsert {
    public static void mainInsert(String prod_vendido, Date data_venda,Double valor_total) {
        Venda venda = new Venda(prod_vendido, data_venda, valor_total);
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.inserir(venda);
    }
}
