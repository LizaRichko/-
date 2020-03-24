
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private AnchorPane Zad1pane;

    @FXML
    private Button Zad1CalcButton;

    @FXML
    private TextField Zad1CondField;

    @FXML
    private Label Zad1AnsLabel;

    @FXML
    private Button Zad2RozrButton;

    @FXML
    private TextField Zad2BDField;

    @FXML
    private TextField Zad2EDField;

    @FXML
    private Label Zad2CondLabel;

    @FXML
    private Label Zad2AnsLabel;

    @FXML
    private TextField Zad3CondField;

    @FXML
    private Button Zad3RozrButton;

    @FXML
    private Label Zad3AnsLabel;

    @FXML
    private TextField Zad4SField;

    @FXML
    private TextField Zad4EField;

    @FXML
    private Button Zad4RozrButton;

    @FXML
    private Label Zad4AnsLabel;

    @FXML
    private TextField Zad5DField;

    @FXML
    private TextField Zad5MField;

    @FXML
    private TextField Zad5YField;

    @FXML
    private TextField Zad5DayField;

    @FXML
    private Button Zad5CalcButton;

    @FXML
    private Label Zad5AnsLabel;

    @FXML
    void initialize() {
        Zad1CalcButton.setOnAction(event -> Zads.zad1Rozr(Zad1CondField, Zad1AnsLabel));
        Zad2RozrButton.setOnAction(event -> Zads.Zad2(Zad2BDField, Zad2EDField, Zad2CondLabel, Zad2AnsLabel));
        Zad3RozrButton.setOnAction(event -> Zads.Zad3(Zad3CondField, Zad3AnsLabel));
        Zad4RozrButton.setOnAction(event -> Zads.Zad4(Zad4SField, Zad4EField, Zad4AnsLabel));
        Zad5CalcButton.setOnAction(event -> Zads.Zad5(Zad5DField, Zad5MField, Zad5YField, Zad5DayField, Zad5AnsLabel));
    }
}