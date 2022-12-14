package com.example.ninodimitriadi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController  implements Initializable {


    @FXML
    private TextField name;
    @FXML
    private  Spinner <Integer> number;
    @FXML
    private ChoiceBox <String> type;
    @FXML
    private Label score;
    @FXML
    private TextArea  generated_numbers;
    @FXML
    private  Button button;
    @FXML
    private Label setname;

    private String[] lst = {"კენტი", "ლუწი", "შერეული"};
    int[] numbs = new int[10];
    int count = 0;
    int scr = 0;

    @FXML
    protected void onButtonClick() {

        setname.setText(name.getText() + ", თქვენი ქულაა:");

        String tipi = type.getValue();

        score.setText(String.valueOf(scr));

        if (tipi == "კენტი"){
            for (int i=0; i<=10; i++){
                int rand = (int) ((Math.random() * (49 - 2)) + 2);
                if (rand%2 == 0) {
                    numbs[i] = rand;
                }
            }
        } else if (tipi == "ლუწი") {
            for (int i=0; i<=10; i++){
                int rand = (int) ((Math.random() * (49 - 2)) + 2);
                if (rand%2 == 1) {
                    numbs[i] = rand;
                }
            }
        } else {
            for (int i=0; i<10; i++){
                int rand = (int) ((Math.random() * (49 - 2)) + 2);
                numbs[i] = rand;
            }
        }
        generated_numbers.setText(Arrays.toString(numbs));

        for (int x=0; x<10; x++){
            if (numbs[x]>25){
                count += 1;
            }
        }

        if (count>5){
            scr += 5;
        }
        if (count<5){
            scr -= 7;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type.getItems().addAll(lst);
        SpinnerValueFactory<Integer> ValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        ValueFactory.setValue(1);
        number.setValueFactory(ValueFactory);
    }
}