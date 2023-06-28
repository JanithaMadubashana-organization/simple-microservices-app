package lk.ijse.dep10.backendspringboot.dao;

import lk.ijse.dep10.backendspringboot.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();
    Book save(Book book);
}
