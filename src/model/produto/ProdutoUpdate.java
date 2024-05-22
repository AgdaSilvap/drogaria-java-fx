
package model.produto;

import dao.ProdutoDAO;

public class ProdutoUpdate {
    public static void mainUpdate(Produto produto) {
        Produto prod = new Produto(produto);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.alterar(prod);
    }
}