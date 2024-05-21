
package model.produto;

import dao.ProdutoDAO;

public class ProdutoDelete {
    public static void mainDelete(Integer id) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.remover(id);
    }
}
