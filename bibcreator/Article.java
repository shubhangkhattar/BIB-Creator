/**
 * COMP 6481 : Assignment 2 
 * @author Garvit Kataria (40155647) and Shubhang Khattar (40163063)
 * @version : 1.0 
 */

package bibcreator;

/**
 * Article class contains all the instance members necessary for the Article.
 */

public class Article {
	String author;
	String journal;
	String title;
	String year;
	String volume;
	String number;
	String pages;
	String keywords;
	String doi;
	String ISSN;
	String month;
	
	public Article(String author, String journal, String title, String year, String volume, String number,
			String pages, String keywords, String doi, String iSSN, String month) {
		super();
		this.author = author;
		this.journal = journal;
		this.title = title;
		this.year = year;
		this.volume = volume;
		this.number = number;
		this.pages = pages;
		this.keywords = keywords;
		this.doi = doi;
		ISSN = iSSN;
		this.month = month;
	}

	public Article() {
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getISSN() {
		return ISSN;
	}

	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Article [author=" + author + ", journal=" + journal + ", title=" + title + ", year=" + year
				+ ", volume=" + volume + ", number=" + number + ", pages=" + pages + ", keywords=" + keywords + ", doi="
				+ doi + ", ISSN=" + ISSN + ", month=" + month + "]";
	}
	
	
	
	
}
