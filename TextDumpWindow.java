import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TextDumpWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a TextArea
        TextArea textArea = new TextArea();
        textArea.setPrefSize(300, 200); // Set preferred size

        // Create a StackPane to hold the TextArea
        StackPane root = new StackPane();
        root.getChildren().add(textArea);

        // Create the Scene
        Scene scene = new Scene(root, 400, 300);

        // Set the scene
        primaryStage.setTitle("Text Dump Window");
        primaryStage.setScene(scene);

        // Create a VBox for the main layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        // Create the "Find Recycling Centres Near Me" button
        Button findRecyclingButton = new Button("Find Recycling Centres Near Me");
        findRecyclingButton.setOnAction(e -> {
            // Open dialog box for user to enter postcode
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(primaryStage);
            VBox dialogVbox = new VBox(20);
            dialogVbox.setPadding(new Insets(10));

            TextField postcodeField = new TextField();
            Button submitButton = new Button("Submit");
            submitButton.setOnAction(event -> {
                String postcode = postcodeField.getText();
                // Perform action with postcode, for example, display it in TextArea
                textArea.appendText("Entered postcode: " + postcode + "\n");
                dialog.close();
            });

            dialogVbox.getChildren().addAll(new Label("Enter your postcode:"), postcodeField, submitButton);
            Scene dialogScene = new Scene(dialogVbox, 300, 150);
            dialog.setScene(dialogScene);
            dialog.show();
        });

        vbox.getChildren().addAll(findRecyclingButton, textArea);

        // Set the main layout (VBox) as the root of the scene
        primaryStage.setScene(new Scene(vbox, 400, 300));

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
