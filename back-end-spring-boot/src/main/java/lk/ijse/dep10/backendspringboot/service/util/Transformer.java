package lk.ijse.dep10.backendspringboot.service.util;
import lk.ijse.dep10.backendspringboot.dto.BookDTO;
import lk.ijse.dep10.backendspringboot.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {
    private final ModelMapper mapper = new ModelMapper();
    public Book toBookEntity(BookDTO bookDTO){
        return mapper.map(bookDTO, Book.class);
    }
    public BookDTO fromBookEntity(Book bookEntity){
        return mapper.map(bookEntity, BookDTO.class);
    }

}
