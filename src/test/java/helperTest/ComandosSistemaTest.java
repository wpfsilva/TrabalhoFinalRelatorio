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

    @BeforeEach
    void setUp() {
        comandosSistema = new ComandosSistema();
    }

    @AfterEach
    void tearDown() {
        // Realizar limpeza após cada teste
    }

    @Test
    void inserirAplicacao() {
        
        Aplicacao aplicacao = new Aplicacao("teste1", "2023-06-17", "cenario teste", 8f, 0);
        aplicacao.setNome("teste1junit");
       
        boolean resultado = comandosSistema.inserirAplicacao(aplicacao);

        
        assertTrue(resultado);
    }

   

    @Test
    void inserirDespesa() {
        
        Despesa despesa = new Despesa("teste2", "2023-06-18", "cenario teste2", 4f);
       
        

       
        boolean resultado = comandosSistema.inserirDespesa(despesa);

        
        assertTrue(resultado);
    }

   

    @Test
    void inserirEmprestimo() {
       
        Emprestimo emprestimo = new Emprestimo("gabriel", "2023-06-17", "cachorras", 2f, 8f, 2, 2f);
       
       
        boolean resultado = comandosSistema.inserirEmprestimo(emprestimo);

        
        assertTrue(resultado);
    }

    

    @Test
    void inserirReceita() {
       
        Receita receita = new Receita("teste4", "2023-06-20", "cenario teste4", 10f);
      
      
       
        boolean resultado = comandosSistema.inserirReceita(receita);

        
        assertTrue(resultado);
    }
    
    
    @Test
    void gerarRelatorio() {
        String tipo = "anual";
        String dataRef = "2023";

        RelatorioAnual relatorio = new RelatorioAnual(dataRef);

        String relatorioString = relatorio.gerarRelatorio(dataRef);

        assertNotNull(relatorioString);
        assertTrue(relatorioString.contains("Relatório"));

        System.out.println(relatorioString);
    }
    
    /*
    @Test
    void gerarRelatorio_DeveRetornarRelatorioValido() {
       
        String tipo = "anual";
        String dataRef = "2023"; 

        
        String relatorio = comandosSistema.gerarRelatorio(tipo, dataRef);

      
        assertNotNull(relatorio);
        assertTrue(relatorio.contains("Relatório"));
    }
    
    

    @Test
    void deletarReceita_DeveDeletarReceitaExistente() {
      
        String nome = "asda";
      String dataOut = "2023-06-17";
       
        boolean resultado = comandosSistema.deletarReceita(nome, dataOut);

       
        assertTrue(resultado);
    }
    @Test
    void deletarEmprestimo_DeveDeletarEmprestimoExistente() {
       
        String nome = "EmprestimoExistente";
        String dataOut = LocalDate.now().toString();

       
        boolean resultado = comandosSistema.deletarEmprestimo(nome, dataOut);

       
        assertTrue(resultado);
    }
    @Test
    void deletarDespesa_DeveDeletarDespesaExistente() {
       
        String nome = "DespesaExistente";
        String dataOut = LocalDate.now().toString(); 

       
        boolean resultado = comandosSistema.deletarDespesa(nome, dataOut);

        
        assertTrue(resultado);
    }
    @Test
    void deletarAplicacao_DeveDeletarAplicacaoExistente() {
       
        String nome = "AplicacaoExistente";
        String dataOut = LocalDate.now().toString();
        
        boolean resultado = comandosSistema.deletarAplicacao(nome, dataOut);

        
        assertTrue(resultado);
    }
    */
}
