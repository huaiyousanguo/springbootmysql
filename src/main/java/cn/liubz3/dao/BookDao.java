package cn.liubz3.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cn.liubz3.entity.Book;

import java.util.*;

public interface BookDao extends CrudRepository<Book, Long> {
	// 查询数量多于制定num的book
	@Query(value = "select b from Book b where b.num>:num")
	public List<Book> seachGreat(@Param("num") int num);

	// 根据名称模糊查询
	@Query("select b from Book b where b.name like %?1%")
	public List<Book> search(String name);
}
