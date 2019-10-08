package cn.itcast.domain;

public class Borrow {
	private Long borrow_id;
	private String borrow_time;
	private String return_time;
	private Double ticket;
	private Long exprie;
	private Student student;
	private Book book;
	
	public Long getBorrow_id() {
		return borrow_id;
	}
	public void setBorrow_id(Long borrow_id) {
		this.borrow_id = borrow_id;
	}
	public String getBorrow_time() {
		return borrow_time;
	}
	public void setBorrow_time(String borrow_time) {
		this.borrow_time = borrow_time;
	}
	public String getReturn_time() {
		return return_time;
	}
	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}
	public Double getTicket() {
		return ticket;
	}
	public void setTicket(Double ticket) {
		this.ticket = ticket;
	}
	public Long getExprie() {
		return exprie;
	}
	public void setExprie(Long exprie) {
		this.exprie = exprie;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
