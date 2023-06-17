package program;

import helper.ComandosSistema;
import insercoes.Aplicacao;

public class Programa {

	public static void main(String[] args) {
		Aplicacao ap = new Aplicacao("a1", null, null, null, 0);
		ComandosSistema.inserirAplicacao(ap);

	}

}
