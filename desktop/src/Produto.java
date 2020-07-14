
public class Produto {

	String codBarras;
	String nome;
	String preco;
	String descricao;
	int quantidade;

	public Produto() {
		String qqrCoisa = "Qualquer Coisa";
	}

	public Produto(String codBarras, String nome, String descricao, String preco, int quantidade) {
		this.codBarras = codBarras;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	// public static void preencherTabela(Connection conexao, ObservableList<Produto> lista) {
	// 	//
	// }

}
