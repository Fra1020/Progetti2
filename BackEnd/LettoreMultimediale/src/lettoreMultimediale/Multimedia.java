package lettoreMultimediale;

import java.util.Scanner;
public abstract class Multimedia {
    private String titolo;

    public Multimedia(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void start() {

    }

    public void editSettings(Scanner in)
    {

    }

}
