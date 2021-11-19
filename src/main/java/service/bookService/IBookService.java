package service.bookService;

import module.Book;

import java.util.List;

public interface IBookService {
    List<Book> showAllBook();
    Book selectBookByID(int id);

}
