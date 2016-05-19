
import consultorioveterinariov3.model.Animal;
import consultorioveterinariov3.model.Cliente;
import consultorioveterinariov3.model.Cota;
import consultorioveterinariov3.model.Fatura;
import consultorioveterinariov3.model.Item;
import consultorioveterinariov3.model.OrdemServico;
import consultorioveterinariov3.model.Servico;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestConsultorioVeterinario {

    public TestConsultorioVeterinario() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testServico() {
        Servico servico = new Servico("Exame Rotina", 120);
        Cliente cliente = new Cliente("Dave Atkins");
        assertEquals("Dave Atkins", cliente.getNomeCliente());
        assertEquals("Exame Rotina", servico.getNomeServico());
        assertEquals(120, servico.getValor(), 0);

    }

    @Test
    public void testPagar() {
        Fatura f = new Fatura();
        double dinheiroRecebido = 100;
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setValorTotal(100);
        f.pagar(dinheiroRecebido, ordemServico);
        assertEquals("Pago", f.getStatus());
    }

    @Test
    public void testExecutarOrdemServico() {
        List<Cliente> clientes = new ArrayList<>();
        List<Item> itens = new ArrayList<>();
        Fatura f;
        Cliente cliente = new Cliente("Dave Atkins");
        clientes.add(cliente);
        Animal animal = new Animal("Fofo", "Doberman", clientes);
        Servico servico = new Servico("Exame Rotina", 150);
        Servico servico2 = new Servico("Vacina Raiva", 50);
        Item item = new Item(1, 150, servico, animal);
        Item item2 = new Item(1, 50, servico2, animal);
        itens.add(item);
        itens.add(item2);
        OrdemServico os = new OrdemServico(itens, cliente);
        f = os.executar(os);
        assertEquals(200, f.getOs().get(0).getValorTotal(), 0);
    }

    @Test
    public void testEmitirFaturaFimDoMes() {
        List<Item> itens = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        Fatura f;
        Cliente cliente = new Cliente("Traci Heinrich");
        clientes.add(cliente);
        Animal animal1 = new Animal("Tweedle Dee", "Gato", clientes);
        Animal animal2 = new Animal("Tweedle Dum", "Gato", clientes);
        Servico servico = new Servico("Esterilização", 300);
        Item item = new Item(1, 300, servico, animal1);
        Item item2 = new Item(1, 300, servico, animal2);
        itens.add(item);
        itens.add(item2);
        OrdemServico os = new OrdemServico(itens, cliente);
        f = os.executar(os);
        f.pagarFimDoMes(f);
        assertEquals(false, f.isAvista());
    }

    @Test
    public void testPagarCotaAnimal() {
        List<Fatura> faturas = new ArrayList<>();
        List<Item> itens = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Cota> cotas = new ArrayList<>();
        Cliente cliente1 = new Cliente("Grady Booch");
        Cliente cliente2 = new Cliente("Martin Fowler");
        Cliente cliente3 = new Cliente("Ralph Jhonson");
        Cliente cliente4 = new Cliente("Erich Gama");
        Cliente cliente5 = new Cliente("Brian Foote");
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);
        Animal animal = new Animal("Mensagem polimorfica", "Cavalo", clientes);
        Cota cota1 = new Cota(cliente1, animal, 30);
        Cota cota2 = new Cota(cliente2, animal, 20);
        Cota cota3 = new Cota(cliente3, animal, 20);
        Cota cota4 = new Cota(cliente4, animal, 10);
        Cota cota5 = new Cota(cliente5, animal, 20);
        cotas.add(cota1);
        cotas.add(cota2);
        cotas.add(cota3);
        cotas.add(cota4);
        cotas.add(cota5);

        Servico servico = new Servico("Esterilizacao", 300);
        Item item = new Item(1, 300, servico, animal);
        itens.add(item);
        OrdemServico os = new OrdemServico(itens, cliente1);
        faturas = os.executarOrdemComCota(os, cotas);
        for (Fatura f : faturas) {
            f.pagarFimDoMes(f);
            assertEquals(false, f.isAvista());
        }
         double pagarCota = 0;
       //for (Cota c: cotas) {
            pagarCota = (servico.getValor() * cota1.getPercentual()) / 100;
             assertEquals(90, pagarCota,0);
        //}
        
       
        

    }

  

}
