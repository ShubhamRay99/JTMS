package base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Book {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="book_id")
	private Integer id;
	@Column(nullable = true)
	private String book_name;
	@Column(nullable = false)
	private Integer number_of_book;
	@Column(nullable = false)
	private Integer book_price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Integer getNumber_of_book() {
		return number_of_book;
	}
	public void setNumber_of_book(Integer number_of_book) {
		this.number_of_book = number_of_book;
	}
	public Integer getBook_price() {
		return book_price;
	}
	public void setBook_price(Integer book_price) {
		this.book_price = book_price;
	}
	
	
}
