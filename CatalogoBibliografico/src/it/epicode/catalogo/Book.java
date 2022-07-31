package it.epicode.catalogo;

public class Book extends Catalog {

	private String author;
	private String genre;

	public Book(String iSBNcode, String title, String publicationYear, int numOfPage, String author, String genre) {
		super(iSBNcode, title, publicationYear, numOfPage);
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Libro [ codice ISBN: " + ISBNcode + ", titolo: " + title + ", Anno di pubblicazione: " + PublicationYear
				+ ", N° di pagine: " + numOfPage + ", autore: " + author + ", genere: " + genre + " ]";
	}

}
