package it.epicode.catalogo;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;


public class ArchiveMain {

//	private static final Logger Log = LoggerFactory.getLogger(ArchiveMain.class);
	private static Map<String, Catalog> mainCatalog = new HashMap<>();

	public static void main(String[] args) throws IOException {

		Catalog book1 = new Book("1234", "Libro 1", "2014", 963, "Autore 1", "Fantasy");
		Catalog book2 = new Book("1534", "Libro 2", "2018", 763, "Autore 2", "Avventura");
		Catalog book3 = new Book("4294", "Libro 3", "2020", 523, "Autore 3", "Drammatico");
		Catalog book4 = new Book("3234", "Libro 4", "2015", 876, "Autore 1", "Avventura");
		Catalog book5 = new Book("7034", "Libro 5", "2022", 126, "Autore 2", "Fantasy");
		Catalog magazine1 = new Magazine("1321", "Rivista 1", "2020", 23, Periodicity.MENSILE);
		Catalog magazine2 = new Magazine("2721", "Rivista 2", "2019", 43, Periodicity.SETTIMANALE);
		Catalog magazine3 = new Magazine("4381", "Rivista 3", "2012", 51, Periodicity.SEMESTRALE);
		Catalog magazine4 = new Magazine("9321", "Rivista 4", "2018", 22, Periodicity.MENSILE);
		Catalog magazine5 = new Magazine("4322", "Rivista 5", "2022", 63, Periodicity.SETTIMANALE);

		addElement(book1);
		addElement(book2);
		addElement(book3);
		addElement(book4);
		addElement(book5);
		addElement(magazine1);
		addElement(magazine2);
		addElement(magazine3);
		addElement(magazine4);
		addElement(magazine5);

		System.out.println("CATALOGO INIZIALE COMPLETO:");
		mainCatalog.forEach((k, v) -> System.out.println(v));
		System.out.println("----------------------------");
		System.out.println("");

		System.out.println("RICERCA PER ANNO (2012):");
		searchForPubblicationYear("2012");
		System.out.println("----------------------------");
		System.out.println("");

		String ISBNCodeToSearch = "3234";
		System.out.println("RICERCA PER CODICE ISBN : (" + ISBNCodeToSearch + ")");
		searchForISBNCode(ISBNCodeToSearch);
		System.out.println("----------------------------");
		System.out.println("");

		System.out.println("RICERCA PER AUTORE (Autore 1):");
		searchForAuthor("Autore 1");
		System.out.println("----------------------------");
		System.out.println("");

		saveOnDisk();

		System.out.println("LETTURA DOPO SCRITTURA SU DISCO:");
		loadFromDisk();

	}

	public static void addElement(Catalog element) {
		mainCatalog.put(element.getISBNcode(), element);
	}

	public static void deleteElement(Catalog element) {
		mainCatalog.remove(element.getISBNcode());
	}

	public static void searchForISBNCode(String ISBNcode) {
		System.out.println(mainCatalog.get(ISBNcode));
	}

	public static void searchForPubblicationYear(String pubblicationYear) {
		mainCatalog.values().stream().filter(c -> c.getPublicationYear() == pubblicationYear)
				.forEach(System.out::println);

	}

	public static void searchForAuthor(String author) {
		mainCatalog.values().stream().filter(e -> e instanceof Book && ((Book) e).getAuthor() == author)
				.forEach(System.out::println);
	}

	public static void saveOnDisk() throws IOException {

		String catalogToText = "";

		for (Catalog cat : mainCatalog.values()) {
			catalogToText += (cat.toString() + ";");
		}

		File catalogFile = new File("./catalog.txt");

		FileUtils.writeStringToFile(catalogFile, catalogToText, "UTF-8");
	}

	public static void loadFromDisk() throws IOException {

		File file = new File("./catalog.txt");

		String readString = FileUtils.readFileToString(file, "UTF-8");
		String[] catalog = readString.split(";");

		for (String element : catalog) {
			System.out.println(element);
		}

	}

}
