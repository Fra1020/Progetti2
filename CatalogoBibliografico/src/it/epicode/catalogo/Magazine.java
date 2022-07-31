package it.epicode.catalogo;

public class Magazine extends Catalog {

	Periodicity periodicity;

	public Magazine(String iSBNcode, String title, String publicationYear, int numOfPage, Periodicity periodicity) {
		super(iSBNcode, title, publicationYear, numOfPage);
		this.periodicity = periodicity;
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return "Rivista [ codice ISBN: " + ISBNcode + ", titolo: " + title + ", Anno di pubblicazione: " + PublicationYear
				+ ", N° di pagine: " + numOfPage + ", Periodicità: " + periodicity + " ]";
	}

}
