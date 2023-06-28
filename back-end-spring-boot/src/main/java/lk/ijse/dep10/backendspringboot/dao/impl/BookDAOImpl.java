package lk.ijse.dep10.backendspringboot.dao.impl;

import lk.ijse.dep10.backendspringboot.dao.BookDAO;
import lk.ijse.dep10.backendspringboot.dto.BookDTO;
import lk.ijse.dep10.backendspringboot.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
@Repository
public class BookDAOImpl implements BookDAO {
    private final JdbcTemplate jdbcTemplate;

    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private static final RowMapper<Book> BOOK_ROW_MAPPER = (rs, rowNum) -> Book.builder()
            .isbn(rs.getString("isbn"))
            .title(rs.getString("title")).build();

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("select * from book",BOOK_ROW_MAPPER);
    }

    @Override
    public Book save(Book book) {
        jdbcTemplate.update(con -> {
            PreparedStatement stm = con.prepareStatement("insert into book(isbn, title) value (?,?)");
            stm.setString(1,book.getIsbn());
            stm.setString(2,book.getTitle());
            return stm;
        });
        return book;

    }
}
