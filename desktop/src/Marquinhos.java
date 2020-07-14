import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.*;
import java.util.*;

public class Marquinhos extends Application{
	private TextField txtUsuario = new TextField();
	private PasswordField txtSenha = new PasswordField();

	private Button btnLogin = new Button("Entrar");

	private Label lblResText = new Label();

	private VBox layout = new VBox();


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("Started");

		stage.setTitle("Lira's Sell Managment");


		// System.exit(0);

		layout.getChildren().addAll(txtUsuario, txtSenha, lblResText, btnLogin);

		txtUsuario.setPromptText("Usuário");
		txtSenha.setPromptText("Senha");

		Scene scn = new Scene(layout, 400, 300);
		stage.setScene(scn);
		stage.setResizable(false);
		stage.show();

		txtUsuario.setTranslateX(75); txtUsuario.setTranslateY(100); txtUsuario.setMaxWidth(250);
		txtSenha.setTranslateX(75); txtSenha.setTranslateY(115); txtSenha.setMaxWidth(250);
		btnLogin.setTranslateX(175); btnLogin.setTranslateY(130);
		lblResText.setTranslateX(110);	lblResText.setTranslateY(120);

		scn.getStylesheets().add("/style.css");

		layout.getStyleClass().add("layoutPrincipal");

		btnLogin.setOnAction(e -> {
			lblResText.setText("");
			// if(txtUsuario.getText().equals("marquinhos") && txtSenha.getText().equals("loja123")) {
				new Consulta().start(Consulta.stg);
			// } else {
				// lblResText.setText("Usuário ou Senha incorretos");
			// }
		});



	}



}
