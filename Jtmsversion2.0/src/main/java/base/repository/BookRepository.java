package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import base.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
