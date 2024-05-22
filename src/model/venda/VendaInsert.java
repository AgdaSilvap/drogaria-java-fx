package model.venda;

import dao.VendaDAO;


public class VendaInsert {
    public static void mainInsert(String nome_prod, String data_venda, Double preco) {
        Venda venda = new Venda(nome_prod, data_venda, preco);
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.inserir(venda);
    }
}
