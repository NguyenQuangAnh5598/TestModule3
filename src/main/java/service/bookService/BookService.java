package service.bookService;

import config.ConnectSingleton;
import module.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    private List<Book>  bookList;
    Connection connection = ConnectSingleton.getConnection();
    @Override
    public List<Book> showAllBook() {
        List<Book> bookList = new ArrayList<>();
       try {
           PreparedStatement preparedStatement = connection.prepareStatement("select * from book;");
           ResultSet rs = preparedStatement.executeQuery();
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
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from book where id = ?;");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
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

    public void borrowBook(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update book set count = count - 1 where id = ?;");
       preparedStatement.setInt(1,id);
       preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update book set count = count + 1 where id = ?;");
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
