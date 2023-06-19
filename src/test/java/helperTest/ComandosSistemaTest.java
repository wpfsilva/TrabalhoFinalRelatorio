package helperTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import helper.ComandosSistema;
import insercoes.Aplicacao;
import insercoes.Despesa;
import insercoes.Emprestimo;
import insercoes.Receita;
import relatorio.*;
class ComandosSistemaTest {

    private ComandosSistema comandosSistema;
   private  FabricaRelatorio fr;

    @BeforeEach
    void setUp() {
        comandosSistema = new ComandosSistema();
        fr = new FabricaRelatorio();
    }

    @AfterEach
    void tearDown() {
        
    }

    @Test
    void inserirAplicacao() {
        
        Aplicacao aplicacao = new Aplicacao("teste14", "2023-06-17", "cenario teste", 8f, 0);
        aplicacao.setNome("aplicacao");
       
        boolean resultado = ComandosSistema.inserirAplicacao(aplicacao);

        
        assertTrue(resultado);
    }

   

    @Test
    void inserirDespesa() {
        Despesa despesa = new Despesa("despesa", "2023-06-18", "cenario teste2", 4f);
       
        boolean resultado = ComandosSistema.inserirDespesa(despesa);
        
        assertTrue(resultado);
    }

   

    @Test
    void inserirEmprestimo() {
        Emprestimo emprestimo = new Emprestimo("emprestimo", "2023-06-17", "petshop", 2f, 8f, 2, 2f);
       
        boolean resultado = ComandosSistema.inserirEmprestimo(emprestimo);
        
        assertTrue(resultado);
    }


    

    @Test
    void inserirReceita() {
       
        Receita receita = new Receita("receita", "2023-06-20", "cenario teste42", 10f);
      
      
       
        boolean resultado = ComandosSistema.inserirReceita(receita);

        
        assertTrue(resultado);
    }
    
    
    @Test
    public void testMostrarDiaria() {
        String dataRef = "19/06/2023";
        String resultadoEsperado = "Dia: 19/06/2023 Entradas: /n teste: 2.0 Saidas: /n sas:2.0 Total: 0.0";
        
        
      
        String resultado = ComandosSistema.gerarRelatorio("diario",dataRef);
        
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testMostrarSemanal() {
        String dataRef = "17/06/2023";
        String resultadoEsperado = "Relatório semanal";
        
     
        
        
      
        String resultado = ComandosSistema.gerarRelatorio("semanal",dataRef);
        
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testMostrarMensal() {
        String dataRef = "06/2023";
        String resultadoEsperado = "Relatório mensal"; 
        
        String resultado = ComandosSistema.gerarRelatorio("mensal",dataRef);
        
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testMostrarAnual() {
        String dataRef = "2023";
        String resultadoEsperado = "Relatório anual"; 
        
        String resultado = ComandosSistema.gerarRelatorio("anual",dataRef);
        
        assertEquals(resultadoEsperado, resultado);
    }
    
    
}
