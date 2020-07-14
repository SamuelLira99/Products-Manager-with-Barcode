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
	static TextField txtUsuario = new TextField();
	static PasswordField txtSenha = new PasswordField();

	private Button btnLogin = new Button("Entrar");

	static Label lblResText = new Label();

	private VBox layout = new VBox();

	private DataBase db = new DataBase();

	static boolean situacaoDoCliente, usuarioExiste;

	static String usuario;
	static String senha;


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
		lblResText.setTranslateX(25);	lblResText.setTranslateY(120);

		scn.getStylesheets().add("/style.css");

		layout.getStyleClass().add("layoutPrincipal");

		btnLogin.setOnAction(e -> efetuarLogin());
//



	}//public void start

	public void efetuarLogin() {

		lblResText.setText("");

		try {Thread.sleep(1000);}catch(Exception e){e.printStackTrace();}

		db.verificarUsuario();
		verificarDados();

		usuarioExiste = false;
		situacaoDoCliente = false;
		usuario="";
		senha="";

}//efetuarLogin

public void verificarDados() {
	if(usuarioExiste == true) {

		if (usuario.equals(txtUsuario.getText()) && senha.equals(txtSenha.getText())) {
			if(situacaoDoCliente == true) {
				new Consulta().start(Consulta.stg);
			} else{lblResText.setText("  Infelizmente sua situação de pagamento está irregular :(\nSe você ja efetuou o pagamento ligue para (24) 97404 3841");}
		} else{lblResText.setText("A senha informada está incorreta. Por favor, tente novamente");}

} else{lblResText.setText("Usuário não encontrado. Por favor, tente novamente");}
}//verificarDados



}
