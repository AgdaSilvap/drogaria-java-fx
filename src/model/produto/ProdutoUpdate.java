
package model.produto;

import dao.ProdutoDAO;
import java.sql.Date;

public class ProdutoUpdate {
    public static void mainUpdate(Integer id, String nome_prod, String validade, String fabricante, Double preco) {
        Produto produto = new Produto(id, nome_prod, validade, fabricante, preco);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.alterar(produto);
    }
}