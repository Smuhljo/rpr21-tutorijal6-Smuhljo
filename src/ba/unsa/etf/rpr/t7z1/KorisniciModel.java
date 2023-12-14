package ba.unsa.etf.rpr.t7z1;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisniciList;
    private SimpleObjectProperty<Korisnik> trenutniKorisnik;

    public KorisniciModel() {
        this.korisniciList = FXCollections.observableArrayList();
        this.trenutniKorisnik = new SimpleObjectProperty<>();
    }

    public ObservableList<Korisnik> getKorisniciList() {
        return korisniciList;
    }

    public void setKorisniciList(ObservableList<Korisnik> korisniciList) {
        this.korisniciList = korisniciList;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    public void napuni() {
        // Add sample data to the list for testing
        korisniciList.add(new Korisnik("John", "Doe", "john.doe@example.com", "johndoe", "password1"));
        korisniciList.add(new Korisnik("Jane", "Doe", "jane.doe@example.com", "janedoe", "password2"));
    }
}
