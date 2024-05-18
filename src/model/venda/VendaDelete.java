package model.venda;

import dao.VendaDAO;

public class VendaDelete {
    public static void mainDelete(Integer id) {
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.remover(id);
    }
}