import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.*;
import java.util.*;

public class Cadastro extends Application {
  static Stage stg = new Stage();

  private TextField txtCodBarras = new TextField();
  private TextField txtNome = new TextField();
  private TextField txtPreco = new TextField();
  private TextField txtDescricao = new TextField();
  private TextField txtQuantidade = new TextField();

  private static Label lblBanco = new Label("Status: Aguardando o preenchimento do formulário");

  private Button btn = new Button("Cadastrar produto");

	private VBox layout = new VBox();

  private DataBase db = new DataBase();
  private Produto p = db.p; // p = Produto 'p' instanciado em DataBase

  public static void setLabel(String txt) {
    lblBanco.setText(txt);
  }



  public void start(Stage stage) {

		stg.setTitle("Cadastro");

    txtCodBarras.setPromptText("Código de Barras");
    txtNome.setPromptText("nome");
    txtPreco.setPromptText("preco");
    txtDescricao.setPromptText("descrição");
    txtQuantidade.setPromptText("Quantidade atualmente em estoque");


		// System.exit(0);

		layout.getChildren().addAll(txtCodBarras, txtNome, txtPreco, txtDescricao, txtQuantidade, btn, lblBanco);

		Scene scn = new Scene(layout, 500, 500);
    stg = stage;
		stg.setScene(scn);
    stg.setResizable(false);
		stg.show();



		btn.setOnAction(e -> {
      // Produto p = new Produto();

      p.setCodBarras(txtCodBarras.getText());
      p.setNome(txtNome.getText());
      p.setPreco(txtPreco.getText());
      p.setDescricao(txtDescricao.getText());
      p.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

      System.out.println(p.getCodBarras());
      System.out.println(p.getNome());
      System.out.println(p.getPreco());
      System.out.println(p.getDescricao());
      System.out.println(p.getQuantidade());

      db.inserirDados();
    });
  }
}
