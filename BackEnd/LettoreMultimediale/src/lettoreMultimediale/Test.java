package lettoreMultimediale;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        String titolo;
        int initialVolume = 0; // scegliere
        int initialLuminosita = 3; // scegliere
        int tipologia, durata;

        System.out.println("LETTORE MULTIMEDIALE");
        System.out.println("Ciao! In questo momento riempiremo il lettore con 5 file multimediali!");
        Scanner in = new Scanner(System.in);
        Multimedia[] multi = new Multimedia[5];
        for (int i = 0; i < 5; i++) {
            // flag variabile booleana//
            boolean flag = true;
            while (flag) {
                System.out.println("Che tipologia di file multimediale vuoi inserire? (1 Immagine 2 Audio 3 Video)");
                System.out.println("Hai inserito " + i + " file multimediali.");
                tipologia = in.nextInt();
                in.nextLine();
                switch (tipologia) {

                case 1:
                    System.out.println("Inserire titolo immagine.");
                    titolo = in.nextLine();
                    multi[i] = new Immagine(titolo, initialLuminosita);
                    flag = false;
                    break;
                case 2:
                    System.out.println("Inserire titolo Audio. ");
                    titolo = in.nextLine();
                    System.out.println("Inserire durata Audio " + titolo + ".");
                    durata = in.nextInt();
                    in.nextLine();
                    multi[i] = new Audio(titolo, initialVolume, durata);
                    flag = false;
                    break;
                case 3:
                    System.out.println("Inserire titolo Video. ");
                    titolo = in.nextLine();
                    System.out.println("Inserire durata Video " + titolo + ".");
                    durata = in.nextInt();
                    in.nextLine();
                    multi[i] = new Filmato(titolo, initialLuminosita, initialVolume, durata);
                    flag = false;
                    break;
                default:
                    System.out.println("Selezione errata! ");
                    break;
                }
            }
        }

        // Fine inizializazzione menu

        int scelta = 0;
        while (true) {

            System.out.println("Scegli un elemento multimediale da 1-5. Inserisci 0 per uscire!");
            System.out.println("=============");
            System.out.println("    MENU   ");
            for (int i = 0; i < 5; i++) {

                System.out.println((i + 1) + ")" + multi[i].getTitolo());
            }
           
            System.out.println("=============");

            scelta = in.nextInt();
            in.nextLine(); 
            if (scelta == 0) System.exit(1);
            System.out.println("exit");

            multi[scelta - 1].start();
            System.out.println("Ho eseguito i tuoi ordini. Vuoi modificare qualcosa del file multimediale? [Y/N]");
            String choice = in.nextLine();
            if (choice.equals("Y"))
                multi[scelta - 1].editSettings(in);
        }
    }
}

 