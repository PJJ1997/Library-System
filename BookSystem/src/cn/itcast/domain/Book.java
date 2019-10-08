package cn.itcast.domain;

import java.util.HashSet;
import java.util.Set;

public class Book {
	private Long book_id;
	private String book_num;
	private String book_image;
	private String book_name;
	private String writer;
	private Double price;
	private String pubcompany;
	private String buydate;
	private String pubdate;
	private String giveback;
	private Set<Borrow> borrows = new HashSet<Borrow>();
	private Category category;
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	public String getBook_num() {
		return book_num;
	}
	public void setBook_num(String book_num) {
		this.book_num = book_num;
	}
	public String getBook_image() {
		return book_image;
	}
	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPubcompany() {
		return pubcompany;
	}
	public void setPubcompany(String pubcompany) {
		this.pubcompany = pubcompany;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getGiveback() {
		return giveback;
	}
	public void setGiveback(String giveback) {
		this.giveback = giveback;
	}
	public Set<Borrow> getBorrows() {
		return borrows;
	}
	public void setBorrows(Set<Borrow> borrows) {
		this.borrows = borrows;
	}
	public String getBuydate() {
		return buydate;
	}
	public void setBuydate(String buydate) {
		this.buydate = buydate;
	}
	@Override
	public String toString() {
		return "Book [book_num=" + book_num + ", book_image=" + book_image + ", book_name=" + book_name + ", writer="
				+ writer + ", price=" + price + ", pubcompany=" + pubcompany + ", buydate=" + buydate + ", pubdate="
				+ pubdate + ", giveback=" + giveback + ", borrows=" + borrows + ", category=" + category + "]";
	}
}
