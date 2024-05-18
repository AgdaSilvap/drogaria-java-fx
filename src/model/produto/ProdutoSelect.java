
package model.produto;
import dao.ProdutoDAO;
import java.util.List;

public class ProdutoSelect {
   public static List<Produto> mainSelect() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> lista = produtoDAO.listar();
        return lista;
    } 
}
