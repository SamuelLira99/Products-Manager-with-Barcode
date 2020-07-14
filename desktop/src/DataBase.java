import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javafx.collections.*;
import javafx.scene.control.*;

public class DataBase {
	public Produto p = new Produto();


	//Inserir dados no banco
	public void inserirDados() {

		try {
			//Procurar classe no projeto
			Class.forName("com.mysql.jdbc.Driver");

			//Cria conexão com o banco
			// Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/ldb", "root", "");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10213366", "sql10213366", "9vEtsdgZeF");

			//Cria query para executar
			String query = "INSERT INTO produto(codBarras, nome, preco, descricao, quantidade) VALUES(?, ?, ?, ?, ?)";

			//Prepara o comando
			PreparedStatement stmt = conexao.prepareStatement(query);

			//seta os valores na String 'query'
			stmt.setString(1, p.getCodBarras());
			stmt.setString(2, p.getNome());
			stmt.setString(3, "R$ " + p.getPreco());
			stmt.setString(4, p.getDescricao());
			stmt.setInt(5, p.getQuantidade());
			stmt.executeUpdate();

			//fecha comando e conexao
			stmt.close();
			conexao.close();

			//seta label dizendo que foi cadastrado
			Cadastro.setLabel("Status: Produtos cadastrados com sucesso!");

		} catch (ClassNotFoundException e) {
			System.out.println("Classe não Encontrada");
		} catch (SQLException e) {
			Cadastro.setLabel("Status: Ocorreu um erro ao cadastrar os produtos!");
			System.out.println("Status: Ocorreu um erro ao cadastrar os produtos!" + e.getMessage());
		}

	}//inserirDados

	public void consultarDados() {
		ObservableList<Produto> obsProduto = FXCollections.observableArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/ldb", "root", "");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10213366", "sql10213366", "9vEtsdgZeF");

			String value = (String) Consulta.cmbBuscar.getValue();
			String query;// = "SELECT * FROM produto WHERE nome LIKE ?";

			if(value.equals("Buscar por Nome")) {
				query = "SELECT * FROM produto WHERE nome LIKE ?";
			} else if(value.equals("Buscar por Cód. de Barras")) {
				query = "SELECT * FROM produto WHERE codBarras LIKE ?";
			} else {
				query = "SELECT * FROM produto";
			}

			PreparedStatement stmt = conexao.prepareStatement(query);

			stmt.setString(1, "%" + Consulta.txtBuscar.getText() + "%");

			//
			ResultSet rs = stmt.executeQuery();

			//Popular Tabela



		while(rs.next()) {
			obsProduto.add(new Produto(rs.getString("codBarras"), rs.getString("nome"), rs.getString("descricao"), rs.getString("preco"), rs.getInt("quantidade")));
		}
		Consulta.table.setItems(obsProduto);

		stmt.close();
		conexao.close();

	} catch (ClassNotFoundException e) {
		System.out.println("Classe não Encontrada");
	} catch (SQLException e) {
		System.out.println("Erro de SQLException -> " + e.getMessage());
		System.out.println("Caso esteja com a conta atrasada, favor pagar ");
	}
	// return obsProduto;

	}

	//Obter todos os produtos
  // public ObservableList<Produto> obterProduto() {
  //   ObservableList<Produto> obsProduto = FXCollections.observableArrayList();
  //   obsProduto.add(new Produto(p.getcodBarras(), p.getNome(), p.getDescricao(), p.getPreco(), p.getQuantidade()));
  //   return obsProduto;
  // }



}
