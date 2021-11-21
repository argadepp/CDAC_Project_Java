package com.sunbeaminfo.dac.spmvc03.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BOOKS")
public class Book implements Serializable {
	private int bookId;
	private String name;
	private String author;
	private String subject;
	private double price;
	private double priceIncTax;

	public Book() {
		this(0, "", "", "", 0.0);
	}
	
	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public Book(int bookId, String name, String author, String subject, double price) {
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
	}
	@GenericGenerator(name="gen", strategy="native")
	@GeneratedValue(generator="gen")
	@Id
	@Column(name="id")
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Column	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
		this.priceIncTax = this.price + this.price * 0.05;
	}
	@Transient
	public double getPriceIncTax() {
		return priceIncTax;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price="
				+ price + "]";
	}
}
