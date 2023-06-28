package lk.ijse.dep10.backendspringboot.service.impl;

import lk.ijse.dep10.backendspringboot.dao.BookDAO;
import lk.ijse.dep10.backendspringboot.dto.BookDTO;
import lk.ijse.dep10.backendspringboot.service.UserService;
import lk.ijse.dep10.backendspringboot.service.util.Transformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final BookDAO bookDAO;
    private final Transformer transformer;
    public UserServiceImpl(BookDAO bookDAO, Transformer transformer) {
        this.bookDAO = bookDAO;
        this.transformer = transformer;
    }

    @Override
    public List<BookDTO> findAllBooks() {
        return bookDAO.findAll().stream().map(transformer::fromBookEntity)
                .collect(Collectors.toList());
    }


    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
         bookDAO.save(transformer.toBookEntity( bookDTO));
         return bookDTO;
    }
}
