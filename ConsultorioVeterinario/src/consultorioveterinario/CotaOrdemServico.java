/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorioveterinario;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabiano.eger
 */
public class CotaOrdemServico extends OrdemServico {
private List<Item> itens;
private CotaCliente cliente;
    public CotaOrdemServico(List<Item> itens, CotaCliente cliente){
        this.itens = itens;
        this.cliente = cliente;
    }
    public List<Fatura> executar(CotaOrdemServico ordemServico, CotaCliente cliente) {
        List<Fatura> faturas = new ArrayList<>();

        double valor;

        double valorOrdem = 0;

        for (int i = 0; i < itens.size(); i++) {
            valorOrdem += itens.get(i).getQuantidade() * itens.get(i).getValorUnitario();
        }

        ordemServico.setValorTotal(valorOrdem);
        Fatura fatura = new Fatura();
        valor = valorCota(cliente.getPercentual(), ordemServico.getValorTotal());
        ordemServico.setValorTotal(valor);
        fatura.addOS(ordemServico);
        fatura.setStatus("Em aberto.");
        faturas.add(fatura);

        return faturas;
    }

    public double valorCota(double percentual, double valor) {
        double percentualAjustado = percentual / 100;
        double resultado = percentualAjustado * valor;
        return resultado;
    }

}
