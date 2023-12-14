package ba.unsa.etf.rpr.t7z1;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;

public class HelloController {

    public ListView listaKorisnika;
    public TextField imeId;
    public TextField prezimeId;
    public TextField emailId;
    public TextField usernameId;
    public PasswordField passwordId;
    public Button krajBtn;
    public Button dodajBtn;

    private ObservableList<Korisnik> korisniciList = FXCollections.observableArrayList();

    @FXML
    public void DodajKorisnika(ActionEvent event) {
        Korisnik korisnik = new Korisnik(imeId.getText(), prezimeId.getText(), emailId.getText(), usernameId.getText(), passwordId.getText());

        korisniciList.add(korisnik);

        listaKorisnika.setItems(korisniciList);

        imeId.clear();
        prezimeId.clear();
        emailId.clear();
        usernameId.clear();
        passwordId.clear();
    }

    @FXML
    public void ZavrsiProgram(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void popuniPodatkeKorisnika(MouseEvent mouseEvent) {
        listaKorisnika.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Korisnik selectedKorisnik = (Korisnik) listaKorisnika.getSelectionModel().getSelectedItem();
                if (selectedKorisnik != null) {
                    imeId.setText(selectedKorisnik.imeProperty().getValue());
                    prezimeId.setText(selectedKorisnik.prezimeProperty().getValue());
                    emailId.setText(selectedKorisnik.emailProperty().getValue());
                    usernameId.setText(selectedKorisnik.usernameProperty().getValue());
                    passwordId.setText(selectedKorisnik.passwordProperty().getValue());
                }
            }
        });
    }


}