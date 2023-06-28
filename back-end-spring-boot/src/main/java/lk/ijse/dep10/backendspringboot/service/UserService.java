package lk.ijse.dep10.backendspringboot.service;

import lk.ijse.dep10.backendspringboot.dto.BookDTO;

import java.util.List;

public interface UserService {
    List<BookDTO> findAllBooks();
    BookDTO saveBook(BookDTO bookDTO);
}
