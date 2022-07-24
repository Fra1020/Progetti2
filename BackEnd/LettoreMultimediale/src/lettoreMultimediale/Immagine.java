package lettoreMultimediale;

import java.util.Scanner;
public class Immagine extends Multimedia implements Luminosita{
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita ;
    }

    public void editSettings(Scanner in)
    {
        int luminosita;
        System.out.println("Inserire nuovo valore di Luminosità per " + getTitolo());
        luminosita = in.nextInt();
        in.nextLine();
        if (this.luminosita > luminosita)
            darker(luminosita);
        else
            brighter(luminosita);
    }

    public void show() {
        String asterischi = "";
        for (int a = 0; a < this.luminosita; a++) {
            asterischi += "*";
        }
        System.out.println(getTitolo() + " " + asterischi);
    }

    @Override
    public void brighter(int bright) {
        if (bright > this.luminosita) this.luminosita = bright;
        else System.out.println("valore inserito inferiore o uguale");
    }

    @Override
    public void darker(int dark) {
        if (dark < this.luminosita) this.luminosita = dark;
        else System.out.println("valore inserito superiore o uguale");
    }



}