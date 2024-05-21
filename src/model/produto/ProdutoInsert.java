
package model.produto;

import dao.ProdutoDAO;
import java.sql.Date;


public class ProdutoInsert {
   public static void produtoInsert(String nome_prod, String validade, String fabricante, Double preco) {
        Produto produto = new Produto(nome_prod, validade, fabricante, preco);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.inserir(produto);
    } 
}
