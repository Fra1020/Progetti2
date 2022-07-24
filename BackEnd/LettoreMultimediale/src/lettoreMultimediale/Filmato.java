package lettoreMultimediale;

import java.util.Scanner;
public class Filmato extends Multimedia implements Volume, Luminosita{
    private int luminosita;
    private int volume;
    private int durata;

    public Filmato(String titolo, int luminosita, int volume, int durata) {
        super(titolo);
        this.luminosita = luminosita;
        this.volume = volume;
        this.durata = durata;
    }

    public void editSettings(Scanner in)
    {
        int luminosita,volume;
        System.out.println("Inserire nuovo valore di Luminosità per " + getTitolo());
        luminosita = in.nextInt();
        in.nextLine();
        if (this.luminosita > luminosita)
            darker(luminosita);
        else
            brighter(luminosita);

        System.out.println("Inserire il nuovo valore di Volume per " + getTitolo());
        volume = in.nextInt();
        in.nextLine();
        if (this.volume > volume)
            weaker(volume);
        else
            louder(volume);
    }

    public void play() {
        String asterischi = ""; String esclamativo = ""; String durata = "";
        for (int a = 0; a < this.luminosita; a++) {
            asterischi += "*";
        }
        for (int a = 0; a < this.volume; a++) {
            esclamativo += "!";
        }
        for (int a = 0; a < this.durata; a++) {
            durata += getTitolo();
        }
        System.out.println(durata + " " + esclamativo + " " + asterischi);
    }

    @Override
    public void brighter(int bright) {
        this.luminosita = bright;

    }

    @Override
    public void darker(int dark) {
        this.luminosita = dark;

    }

    @Override
    public void weaker(int weak) {
        this.volume = weak;

    }

    @Override
    public void louder(int loud) {
        this.volume = loud;
    }


}