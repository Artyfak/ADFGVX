package com.example.adfgx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ADFGXController {
    ADFGXBrain brain = new ADFGXBrain();
    @FXML
    private TextField TFprvotnytext;
    @FXML
    private TextField TFheslo;
    @FXML
    private TextArea TF_6x6;
    @FXML
    private TextArea text_norm;
    @FXML
    private TextArea text_sifs1;
    @FXML
    void handle_text() {
        // Text area nativita
        TF_6x6.setWrapText(true);
        text_norm.setWrapText(true);
        text_sifs1.setWrapText(true);
        // naplnenie poľa 6x6
        TF_6x6.setText(brain.getGridAsString(brain.getPole6x6()));
        brain.setPrvotnytext(TFprvotnytext.getText());
        text_norm.setText(brain.normalize());
        text_sifs1.setText(brain.pridajk2m(brain.vratZasifrovanyText()));
        System.out.println(brain.vratpocetstlp(brain.getHeslo()));
    }
    @FXML
    void handle_heslo() {
        brain.setHeslo(TFheslo.getText());

    }





}