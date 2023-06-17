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
	public String gerarRelatorio(String dataRef) {
		HashMap<String, Float> entradas = new HashMap<>();
		HashMap<String, Float> saidas = new HashMap<>();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoFinalPOO");
		EntityManager em = emf.createEntityManager();

		try {
			String jpql = "SELECT a FROM Aplicacao a WHERE a.dataIn LIKE :ano";
			TypedQuery<Aplicacao> query = em.createQuery(jpql, Aplicacao.class);
			query.setParameter("ano", "%" + anoRef);
			List<Aplicacao> resultados = query.getResultList();
			for (Aplicacao aplicacao : resultados) {
				entradas.put(aplicacao.getNome(), aplicacao.getValor());
			}

			jpql = "SELECT a FROM Despesa a WHERE a.dataIn LIKE :ano";
			TypedQuery<Despesa> query2 = em.createQuery(jpql, Despesa.class);
			query2.setParameter("ano", "%" + anoRef);
			List<Despesa> resultados2 = query2.getResultList();
			for (Despesa despesa : resultados2) {
				saidas.put(despesa.getNome(), despesa.getValor());
			}

			jpql = "SELECT a FROM Receita a WHERE a.dataIn LIKE :ano";
			TypedQuery<Receita> query4 = em.createQuery(jpql, Receita.class);
			query4.setParameter("ano", "%" + anoRef);
			List<Receita> resultados4 = query4.getResultList();
			for (Receita receita : resultados4) {
				entradas.put(receita.getNome(), receita.getValor());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

		Float total = 0f;
		texto = "Ano: " + anoRef + "\n";
		texto += "Entradas:\n";
		for (String chave : entradas.keySet()) {
			Float valor = entradas.get(chave);
			texto += chave + ": " + Float.toString(valor) + "\n";
			total += valor;
		}
		texto += "Saídas:\n";
		for (String chave : saidas.keySet()) {
			Float valor = saidas.get(chave);
			texto += chave + ": " + Float.toString(valor) + "\n";
			total -= valor;
		}
		texto += "Total: " + Float.toString(total);
		return texto;
	}
}
