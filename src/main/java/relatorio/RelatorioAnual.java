package relatorio;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import insercoes.Aplicacao;
import insercoes.Despesa;
import insercoes.Emprestimo;
import insercoes.Receita;

public class RelatorioAnual implements Relatorio {
	private String anoRef;
	private String texto;

	public RelatorioAnual(String anoRef) {
		this.anoRef = anoRef;
	}

	@Override
	public String gerarRelatorio(String anoRef) {
		RelatorioMensal rl = new RelatorioMensal();
		texto = "Ano: " + anoRef + "\n";
		Float valorTotal = (float) 0;
		texto += rl.gerarRelatorio("01/" + anoRef);
		String[] textoAux = texto.split("\n");
		String[] ultEle = textoAux[textoAux.length-1].split(" ");
		Float valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += rl.gerarRelatorio("02/" + anoRef);
		textoAux = texto.split("\n");
		ultEle = textoAux[textoAux.length-1].split(" ");
		valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += rl.gerarRelatorio("03/" + anoRef);
		textoAux = texto.split("\n");
		ultEle = textoAux[textoAux.length-1].split(" ");
		valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += rl.gerarRelatorio("04/" + anoRef);
		textoAux = texto.split("\n");
		ultEle = textoAux[textoAux.length-1].split(" ");
		valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += rl.gerarRelatorio("05/" + anoRef);
		textoAux = texto.split("\n");
		ultEle = textoAux[textoAux.length-1].split(" ");
		valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += rl.gerarRelatorio("06/" + anoRef);
		textoAux = texto.split("\n");
		ultEle = textoAux[textoAux.length-1].split(" ");
		valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += rl.gerarRelatorio("07/" + anoRef);
		textoAux = texto.split("\n");
		ultEle = textoAux[textoAux.length-1].split(" ");
		valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += rl.gerarRelatorio("08/" + anoRef);
		textoAux = texto.split("\n");
		ultEle = textoAux[textoAux.length-1].split(" ");
		valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += rl.gerarRelatorio("09/" + anoRef);
		textoAux = texto.split("\n");
		ultEle = textoAux[textoAux.length-1].split(" ");
		valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += rl.gerarRelatorio("10/" + anoRef);
		textoAux = texto.split("\n");
		ultEle = textoAux[textoAux.length-1].split(" ");
		valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += rl.gerarRelatorio("11/" + anoRef);
		textoAux = texto.split("\n");
		ultEle = textoAux[textoAux.length-1].split(" ");
		valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += rl.gerarRelatorio("12/" + anoRef);
		textoAux = texto.split("\n");
		ultEle = textoAux[textoAux.length-1].split(" ");
		valorUlt = Float.parseFloat(ultEle[ultEle.length-1]);
		valorTotal += valorUlt;
		
		texto += "Valor Final do Ano: " + String.valueOf(valorTotal)+"\n";
		return texto;
	}
}
