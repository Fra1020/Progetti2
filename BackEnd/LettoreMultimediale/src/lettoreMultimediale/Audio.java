package lettoreMultimediale;

import java.util.Scanner;
public class Audio extends Multimedia implements Volume {
    private int volume;
    private int durata;

    public Audio(String titolo, int volume, int durata) {
        super(titolo);
        this.volume = volume;
        this.durata = durata;
    }

    public void start()
    {
        play();
    }

        //metodo per aumentare o diminuire il volume 
        public void editSettings(Scanner in) {

        int volume = 0;
        System.out.println("Inserire il nuovo valore di Volume per " + getTitolo());
        volume = in.nextInt();
        in.nextLine();
        if (this.volume > volume)
            weaker(volume);
        else
            louder(volume);
    }
    //metodo per assegnare il volume in punti esclamativi e la durata
    public void play() {
        String esclamativo = "";
        String durata = "";
        for (int a = 0; a < this.volume; a++) {
            esclamativo += "!";
        }
        for (int a = 0; a < this.durata; a++) {
            durata += getTitolo();
        }
        System.out.println(durata + " " + esclamativo);
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