package consultorioveterinario;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    private String nomeAnimal;
    private String raca;
    private List<CotaCliente> clientes;

    public Animal(String nomeAnimal, String raca) {
        this.nomeAnimal = nomeAnimal;
        this.raca = raca;
        this.clientes = new ArrayList<>();
    }

    public void addDono(CotaCliente cliente) {
        this.clientes.add(cliente);
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public List<CotaCliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<CotaCliente> clientes) {
        this.clientes = clientes;
    }

}
