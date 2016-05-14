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
public class CotaCliente{
    private String nome;
   private double percentual;

    public CotaCliente(String nome, double percentual) {
        this.nome = nome;
        this.percentual = percentual;
    }

   

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }
   





}
