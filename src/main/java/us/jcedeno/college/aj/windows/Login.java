package us.jcedeno.college.aj.windows;

import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import lombok.Getter;
import us.jcedeno.college.aj.Main;
import us.jcedeno.college.aj.objects.SWChar;

public class Login {
    private Main instance;
    private @Getter Scene scene;

    public Login(Main instance) {
        this.instance = instance;
        var screen = Screen.getPrimary().getBounds();

        var text = new Text("Welcome");
        text.setFont(new Font(24));
        text.setSmooth(true);

        var alertText = new Text();
        alertText.setVisible(false);
        alertText.setFill(Color.RED);

        var comboBox = new ComboBox<>();
        comboBox.getItems().addAll(SWChar.of("Obiwan"), SWChar.of("R2D2"), SWChar.of("Chewbacca"),
                SWChar.of("Han Solo"), SWChar.of("Darth Vader"));
        // Select random character on startup
        comboBox.getSelectionModel().select(new Random().nextInt(comboBox.getItems().size()));
        var textField = new TextField();
        textField.setPadding(new Insets(10, 0, 0, 0));
        textField.setPromptText("Enter username");
        var submitButton = new Button("Submit");
        // Submit button logic
        submitButton.setOnAction(event -> {
            var selectedItem = comboBox.getSelectionModel().getSelectedItem();
            var username = textField.getText();

            alertText.setFill(Color.RED);
            alertText.setVisible(true);

            if (username.isEmpty() || username.length() < 3) {
                alertText.setText("You must type a name");
            } else if (selectedItem == null) {
                alertText.setText("You must select a character");
            } else {
                alertText.setText("Logging you in...");
                alertText.setFill(Color.GREEN);
                AlertBox.display("Notification", "Loggen in as " + username);
                
                instance.getPrimaryStage().setScene(new App(instance.getPrimaryStage()));

            }
        });
        // Logic ends
        //Containers for spacing
        var verticalBox = new VBox(new Text(" Username:"), textField);
        verticalBox.setAlignment(Pos.CENTER_LEFT);

        var verticalBoxCombo = new VBox(new Text("Favorite Character:"), comboBox);
        verticalBox.setAlignment(Pos.CENTER_LEFT);

        var pane = new HBox(verticalBox, verticalBoxCombo);
        pane.setSpacing(10);
        pane.setAlignment(Pos.CENTER);

        var vertical = new VBox(text, new Text(), pane, alertText, submitButton);
        vertical.setAlignment(Pos.CENTER);
        vertical.setSpacing(10);

        scene = new Scene(vertical, screen.getWidth() / 6, screen.getHeight() / 4);
    }

}
