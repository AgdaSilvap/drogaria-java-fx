
import dao.ProdutoDAO;
import java.sql.Date;
import model.produto.Produto;

public class ProdutoInsert {
    public static void produtoInsert(String nome_prod, Date validade, String fabricante, Double preco) {
        Produto produto = new Produto(nome_prod, validade, fabricante, preco);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.inserir(produto);
    }
}
