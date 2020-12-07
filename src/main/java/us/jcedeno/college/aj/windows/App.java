package us.jcedeno.college.aj.windows;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Scene {

    public App(Stage primaryStage) {
        super(new VBox(), (Screen.getPrimary().getBounds().getWidth() / 5) * 3,
                Screen.getPrimary().getBounds().getHeight() /1.5);

        var root = ((VBox) getRoot());
        primaryStage.setTitle("Final Project :: Logged in");
        primaryStage.setResizable(true);
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(new Button("test"));

    }

}
