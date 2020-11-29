/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

    private String arvo;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.arvo = tuloskentta.getText();

        int lisays = Integer.valueOf(syotekentta.getText());
        this.sovellus.plus(lisays);

        String tulos = String.valueOf(this.sovellus.tulos());
        this.tuloskentta.setText(tulos);

        this.syotekentta.setText("");

        if (Integer.valueOf(tulos) == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }

        undo.disableProperty().set(false);

    }

    @Override
    public void peru() {
        this.tuloskentta.setText(this.arvo);
        this.syotekentta.setText("");

    }
}
