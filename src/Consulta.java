import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.beans.value.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.*;
import javafx.collections.*;
import java.util.*;

public class Consulta extends Application {
  static Stage stg = new Stage();

  static TextField txtBuscar = new TextField();

  static Label lblProduto = new Label("PRODUTO \n\n");
  static Label lblDescricao = new Label("DESCRIÇÃO \n\n");
  static Label lblPreco = new Label("PREÇO \n\n");
  static Label lblQuantidade = new Label("QTDE \n\n");

  static ComboBox<String> cmbBuscar = new ComboBox<>();
  private Button btnBuscar = new Button("Buscar");
  private Button btnCadastrar = new Button("Novo Produto");

  private VBox layout = new VBox();
  private HBox hb1 = new HBox();
  private HBox hb2 = new HBox();

  private Produto p = new Produto();
  private DataBase db = new DataBase();

  static TableView<Produto> table = new TableView<>();

  public void start(Stage stage) {

    TableColumn<Produto, String> colProduto = new TableColumn<>("Produto");
    colProduto.setPrefWidth(200);
    colProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));

    TableColumn<Produto, String> colPreco = new TableColumn<>("Preço");
    colPreco.setPrefWidth(100);
    colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

    TableColumn<Produto, String> colDescricao = new TableColumn<>("Descrição");
    colDescricao.setPrefWidth(500);
    colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

    TableColumn<Produto, Integer> colQuantidade = new TableColumn<>("Quantidade");
    colQuantidade.setPrefWidth(100);
    colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));


    table.getColumns().addAll(colProduto, colDescricao, colPreco, colQuantidade);
    // table.setItems(obterProduto());
    // table.setItems(DataBase.consultarDados());
    table.setEditable(true);

    cmbBuscar.getItems().addAll("Buscar por Nome", "Buscar por Cód. de Barras");
    cmbBuscar.setValue("Buscar por Nome");

    Scene scn = new Scene(layout, 900, 800);
    stg = stage;
    stg.setScene(scn);
    stg.show();

    layout.getChildren().addAll(table, hb1, hb2);
    hb1.getChildren().addAll(txtBuscar, cmbBuscar, btnBuscar, btnCadastrar);
    hb2.getChildren().addAll(lblProduto, lblDescricao, lblPreco, lblQuantidade);

    txtBuscar.setPromptText("Nome ou Cód. do Produto");

    btnBuscar.setOnAction(e -> buscar());
    btnCadastrar.setOnAction(e -> new Cadastro().start(Cadastro.stg));
    db.consultarDados();

    txtBuscar.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.ENTER) {
        buscar();
      }
    });

  }

  public void buscar() {
    lblProduto.setText("PRODUTO\n\n");
    lblDescricao.setText("DESCRIÇÃO\n\n");
    lblPreco.setText("PRECO\n\n");
    lblQuantidade.setText("QUANTIDADE\n\n");
    db.consultarDados();
  }

  //Obter todos os produtos
  // public static ObservableList<Produto> obterProduto() {
  //   ObservableList<Produto> obsProduto = FXCollections.observableArrayList();
  //   obsProduto.add(new Produto("produto1", "DescriçãodoProduto1", "RS Preço", 2));
  //   obsProduto.add(new Produto("produto2", "DescriçãodoProduto2", "RS Preço", 2));
  //   obsProduto.add(new Produto("produto3", "DescriçãodoProduto3", "RS Preço", 2));
  //   obsProduto.add(new Produto("produto4", "DescriçãodoProduto4", "RS Preço", 2));
  //   obsProduto.add(new Produto("produto5", "DescriçãodoProduto5", "RS Preço", 2));
  //   return obsProduto;
  // }


  // public static void setTableItems(String dbNome, String dbDescricao, String dbPreco, int dbQuantidade) {
  //   table.setItems(dbNome, dbDescricao, dbPreco, dbQuantidade);
  // }

}
