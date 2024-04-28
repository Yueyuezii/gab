import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        TextField n1 = new TextField();
        TextField n2 = new TextField();
        Label resultLabel = new Label();

        Button add = new Button("+");
        Button sub = new Button("-");
        Button mul = new Button("*");
        Button div = new Button("/");

        // Event handlers for the buttons
        add.setOnAction(e -> calculateResult(n1, n2, resultLabel, "+"));
       
        sub.setOnAction(e -> calculateResult(n1, n2, resultLabel, "-"));
       
        mul.setOnAction(e -> calculateResult(n1, n2, resultLabel, "*"));
       
        div.setOnAction(e -> calculateResult(n1, n2, resultLabel, "/"));

        // Layout setup
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER_LEFT);

        root.getChildren().addAll(
                new Label("Number 1:"), n1,
                new Label("Number 2:"), n2,
                add, sub, mul, div,
                resultLabel
        );

        // Set up the scene and show the stage
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();
    }

    private void calculateResult(TextField n1, TextField n2, Label resultLabel, String operator) {
        try {
            double num1 = Double.parseDouble(n1.getText());
            double num2 = Double.parseDouble(n2.getText());
            double result;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        resultLabel.setText("Cannot divide by zero!");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    resultLabel.setText("Invalid operator");
                    return;
            }
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }

    public static void main(String [] args) {
        launch(args);
    }
}