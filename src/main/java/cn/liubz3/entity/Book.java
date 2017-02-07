package cn.liubz3.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class Book implements Serializable {
	@Id
	@GeneratedValue
	private long book_id;
	@NotNull
	private String name;
	@Column(name = "number")
	private int num;

	public long getBook_id() {
		return book_id;
	}

	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return String.format("Book [book_id=%d, name=%s, num=%d]",
				this.book_id, this.name, this.num);
	}

}
