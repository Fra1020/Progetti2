package it.epicode.catalogo;

public abstract class Catalog {

	protected String ISBNcode;
	protected String title;
	protected String PublicationYear;
	protected int numOfPage;

	public Catalog(String iSBNcode, String title, String publicationYear, int numOfPage) {
		this.ISBNcode = iSBNcode;
		this.title = title;
		this.PublicationYear = publicationYear;
		this.numOfPage = numOfPage;
	}

	public String getISBNcode() {
		return ISBNcode;
	}

	public void setISBNcode(String iSBNcode) {
		ISBNcode = iSBNcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublicationYear() {
		return PublicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		PublicationYear = publicationYear;
	}

	public int getNumOfPage() {
		return numOfPage;
	}

	public void setNumOfPage(int numOfPage) {
		this.numOfPage = numOfPage;
	}

}
