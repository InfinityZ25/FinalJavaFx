package us.jcedeno.college.aj.windows;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message) {
        var window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setAlwaysOnTop(true);
        window.setMinWidth(250);

        var label = new Label(message);
        var button = new Button("Ok");
        button.setOnAction(e -> window.close());

        var layout = new VBox(10);
        layout.getChildren().addAll(label, button, new Text());
        layout.setAlignment(Pos.CENTER);

        var scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }

}
