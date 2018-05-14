import br.cefetrj.psw.prova.ContaOrcamento;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author denis
 */
public class ContaOrcamentoTest {
    
    
    
    
    /**
     * Teste do método getValorDisponivel.
     */    
    @Test
    public void testDisponivel() {
        System.out.println("getValorDisponivel");
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);
        instance.setValorRealizado(5);
        double expResult = 12;
        double result = instance.getValorDisponivel();
        assertEquals(expResult, result,0.001);
    }
    
    /**
     * Teste do método getValorComprometido.
     */    
    @Test
    public void testComprometido() {
        System.out.println("getValorComprometido");
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);
        double expResult = 3;
        double result = instance.getValorComprometido();
        assertEquals(expResult, result,0.0);

    }
    
    /**
     * Teste do método getValorOrcado.
     */
    @Test
    public void testOrcado() {
        System.out.println("getValorOrcado");
        ContaOrcamento instance = new ContaOrcamento("", 20,5,2);
        double expResult = 20.0;
        double result = instance.getValorOrcado();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Teste do método getValorRealizado.
     */    
    @Test
    public void testRealizado() {
        System.out.println("getValorRealizado");
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);        
        double expResult = 5;
        double result = instance.getValorRealizado();
        assertEquals(expResult, result,0.0);

    }
    
    /**
     * Teste do método getValorDisponivel quando possui sub conta.
     */ 
    
    @Test
    public void testDisponivelSubConta() {
        System.out.println("getValorDisponivelSubConta");
        ContaOrcamento subconta = new ContaOrcamento("teste",20,5,3);
        ArrayList<ContaOrcamento> x = new ArrayList();
        x.add(subconta);
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);
        instance.setSubContasO(x);        
        double expResult = 12;
        double result = instance.getValorDisponivel();
        assertEquals(expResult, result,0.0);         

    }
    
    /**
     * Teste do método getValorComprometido quando possui sub conta.
     */
    
    @Test
    public void testComprometidoSubConta() {
        System.out.println("getValorComprometidoSubConta");
        ContaOrcamento subconta = new ContaOrcamento("teste",20,5,3);        
        ArrayList<ContaOrcamento> x = new ArrayList();
        x.add(subconta);
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);
        instance.setSubContasO(x);        
        double expResult = 3;
        double result = instance.getValorComprometido();
        assertEquals(expResult, result,0.0);
    }
    
    /**
     * Teste do método getValorOrcado quando possui sub conta.
     */
    
    @Test
    public void testOrcadoSubConta() {
        System.out.println("getValorOrcadoSubConta");
        ContaOrcamento subconta = new ContaOrcamento("teste",20,5,3);
        ArrayList<ContaOrcamento> x = new ArrayList();
        x.add(subconta);
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);
        instance.setSubContasO(x);
        double expResult = 20;
        double result = instance.getValorOrcado();
        assertEquals(expResult, result,0.0);

    }
    
    /**
     * Teste do método getValorRealizado quando possui sub conta.
     */
    
    @Test
    public void testRealizadoSubConta() {
        System.out.println("getValorOrcadoSubConta");
        ContaOrcamento subconta = new ContaOrcamento("teste",20,5,3);
        ArrayList<ContaOrcamento> x = new ArrayList();
        x.add(subconta);
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);
        instance.setSubContasO(x);        
        double expResult = 5;
        double result = instance.getValorRealizado();
        assertEquals(expResult, result,0.0);

    }
    
    /**
     * Teste do método possuiSubConta, quando possui sub conta.
     */
    
    @Test
    public void testPossuiConta(){
        ArrayList<ContaOrcamento> y = new ArrayList();
        ContaOrcamento subconta = new ContaOrcamento("teste",20,5,3);
        subconta.setSubContasO(y);
        ArrayList<ContaOrcamento> x = new ArrayList();
        x.add(subconta);
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);
        instance.setSubContasO(x);
        
        boolean expResult = true;
        boolean result = instance.possuiSubConta();
        assertEquals(expResult, result);
    }
    
    /**
     * Teste do método possuiSubConta, quando não possui sub conta.
     */
    @Test
    public void testNaoPossuiConta(){
        ArrayList<ContaOrcamento> y = new ArrayList();
        y = null;
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);
        instance.setSubContasO(y);        
        boolean expResult = false;
        boolean result = instance.possuiSubConta();
        assertEquals(expResult, result);
        
        
    }
    
    /**
     * Teste do método getCod.
     */
    
    @Test
    public void testGetCod(){
        ArrayList<ContaOrcamento> y = new ArrayList();
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);
        instance.setCod("1.");
        String expResult = "1.";
        String result = instance.getCod();
        assertEquals(expResult, result);
        
        
    }
    
    /**
     * Teste do método getNome.
     */
    
    @Test
    public void testGetNome(){
        ArrayList<ContaOrcamento> y = new ArrayList();
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);        
        String expResult = "teste";
        String result = instance.getNome();
        assertEquals(expResult, result);   
    }
    
    /**
     * Teste do método getSubContaO.
     */
    
    @Test
    public void testGetSubContaO() {
        ContaOrcamento subconta = new ContaOrcamento("teste",20,5,3);
        ArrayList<ContaOrcamento> x = new ArrayList();
        x.add(subconta);
        ContaOrcamento instance = new ContaOrcamento("teste",20,5,3);
        instance.setSubContasO(x);
        ArrayList<ContaOrcamento> expResult = x;
        ArrayList<ContaOrcamento> result = instance.getSubContasO();
        assertEquals(expResult, result);        
    }
    
}
