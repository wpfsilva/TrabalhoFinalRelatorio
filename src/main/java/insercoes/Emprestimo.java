package insercoes;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;

@Entity
public class Emprestimo extends EntradaDados{
	protected Float juros;
	protected Integer mesesParcelas;
	protected Float parcela;
	public Emprestimo() {
        // construtor sem argumentos
    }
	public Emprestimo(String nome, String dataIn, String descricao, Float valor, Float juros,
			Integer mesesParcelas, Float parcela) {
		super(nome, dataIn, descricao, valor);
		this.tipo = "Emprestimo";
		this.juros = juros;
		this.mesesParcelas = mesesParcelas;
		this.parcela = parcela;
		
		String[] dataEmprestimo = dataIn.split("-");
		int meses = mesesParcelas % 12;
		int aux = mesesParcelas - meses;
		int anos = aux/12;
		meses += Integer.parseInt(dataEmprestimo[1]);
		anos += Integer.parseInt(dataEmprestimo[0]);
		this.dataOut = dataEmprestimo[2] + "/" + Integer.toString(meses) + "/" + Integer.toString(anos) + "/";
	}
	
	public Float getValorMes(String dataRef) {
		return getValorData("01/" + dataRef);
	}
	
	public Float getValorData(String dataRef) {
		String[] dataAnalise = dataRef.split("/");
		String[] dataOff = dataOut.split("/");
		String[] dataIn = dataOut.split("/");
		LocalDate dataAnaliseLD = LocalDate.of(Integer.parseInt(dataOff[2]), Integer.parseInt(dataOff[1]), Integer.parseInt(dataOff[0]));
		LocalDate dataInLD = LocalDate.of(Integer.parseInt(dataIn[2]), Integer.parseInt(dataIn[1]), Integer.parseInt(dataIn[0]));
	    LocalDate dataOffLD = LocalDate.of(Integer.parseInt(dataAnalise[2]), Integer.parseInt(dataAnalise[1]), Integer.parseInt(dataAnalise[0]));
		if(dataOut != null) {
		     int comparacao = dataOffLD.compareTo(dataAnaliseLD);
		     int comparacao2 = dataInLD.compareTo(dataAnaliseLD);
		     if(comparacao < 0 || comparacao2 > 0) {
		    	 return (float) 0;
		     }
		}
		 Period periodo = Period.between(dataInLD, dataAnaliseLD);
	     int meses = (int) periodo.toTotalMonths();
	     int mesesPagos = (mesesParcelas - meses);
	     
	     return parcela * (mesesParcelas - mesesPagos);
	}
	public Float getJuros() {
		return juros;
	}
	
	public void setJuros(Float juros) {
		this.juros = juros;
	}
	public Integer getMesesParcelas() {
		return mesesParcelas;
	}
	public void setMesesParcelas(Integer mesesParcelas) {
		this.mesesParcelas = mesesParcelas;
	}
	public Float getParcela() {
		return parcela;
	}
	public void setParcela(Float parcela) {
		this.parcela = parcela;
	}
	
	
	
	
}
