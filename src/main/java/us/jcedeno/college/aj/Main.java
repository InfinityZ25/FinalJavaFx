package us.jcedeno.college.aj;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.Getter;
import us.jcedeno.college.aj.windows.Login;

public class Main extends Application {
    private @Getter Login login;
    private @Getter Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        // Initialize vars.
        this.primaryStage = primaryStage;
        this.login = new Login(this);
        //Display login scene.
        primaryStage.setTitle("Final Project :: Login");
        primaryStage.setScene(login.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}