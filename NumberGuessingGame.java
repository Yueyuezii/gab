import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class NumberGuessingGame extends Application {

    private int numberToGuess;
    private int attempts;

    @Override
    public void start(Stage primaryStage) {
                Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
               Label titleLabel = new Label("Number Guessing Game");
        Label instructionLabel = new Label("Guess the number (between 1 and 100):");
        TextField guessField = new TextField();
        Button guessButton = new Button("Guess");
        Label resultLabel = new Label();
        Label attemptsLabel = new Label("Attempts: 0");

                guessButton.setOnAction(event -> {
            try {
                int guess = Integer.parseInt(guessField.getText());
                attempts++;
                attemptsLabel.setText("Attempts: " + attempts);

                if (guess == numberToGuess) {
                    resultLabel.setText("Congratulations! You guessed the number.");
                } else if (guess < numberToGuess) {
                    resultLabel.setText("Try a higher number.");
                } else {
                    resultLabel.setText("Try a lower number.");
                }
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

               VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titleLabel, instructionLabel, guessField, guessButton, resultLabel, attemptsLabel);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Number Guessing Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}