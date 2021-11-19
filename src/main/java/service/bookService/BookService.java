package service.bookService;

import config.ConnectSingleton;
import module.Book;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    private List<Book>  bookList;
    Connection connection = ConnectSingleton.getConnection();
    @Override
    public List<Book> showAllBook() {
       bookList = new ArrayList<>();
       String query = "call selectAllBook();";
       try {
           CallableStatement callableStatement = connection.prepareCall(query);
           ResultSet rs = callableStatement.executeQuery();
           while (rs.next()) {
               int id = rs.getInt(1);
               String bookCode = rs.getString(2);
               String bookName = rs.getString(3);
               String author = rs.getString(4);
               String description = rs.getString(5);
               int count = rs.getInt(6);
               Book book = new Book(id,bookCode,bookName,author,description,count);
               bookList.add(book);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return bookList;
    }

    @Override
    public Book selectBookByID(int id) {
        Book book = null;
        String query = "call selectBookByID(?);";
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
            if (rs.next()) {
                String bookCode = rs.getString(2);
                String bookName = rs.getString(3);
                String bookAuthor = rs.getString(4);
                String description = rs.getString(5);
                int bookCount = rs.getInt(6);
                book = new Book(id,bookCode,bookName,bookAuthor,description,bookCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
