package lk.ijse.dep10.backendspringboot.api;

import lk.ijse.dep10.backendspringboot.dto.BookDTO;
import lk.ijse.dep10.backendspringboot.entity.Book;
import lk.ijse.dep10.backendspringboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserHttpController {
    private final UserService userService;

    public UserHttpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<BookDTO>getAllBooks(){
        return userService.findAllBooks();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BookDTO saveBook(@RequestBody BookDTO book){
        return userService.saveBook(book);
    }
}
