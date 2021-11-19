package service.cardService;


import config.ConnectSingleton;
import module.Book;
import module.Card;
import module.Student;
import service.bookService.BookService;
import service.studentService.StudentSetvice;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardService implements ICardService {
    private List<Card> cardList;
    private StudentSetvice studentSetvice = new StudentSetvice();
    private BookService bookService = new BookService();
    private Connection connection = ConnectSingleton.getConnection();

    @Override
    public List<Card> selectAllCard() {
        cardList = new ArrayList<>();
        String query = "call selectAllCard();";
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String cardCode = rs.getString(2);
                int bookID = rs.getInt(3);
                int studentID = rs.getInt(4);
                boolean status = rs.getBoolean(5);
                String loanDate = rs.getString(6);
                String backDate = rs.getString(7);
                Book book = bookService.selectBookByID(bookID);
                Student student = studentSetvice.selectStudentByID(studentID);
                cardList.add(new Card(id,cardCode,student,book,status,loanDate,backDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardList;
    }

    @Override
    public Card selectCardByID() {
        return null;
    }

    @Override
    public void createCard(Card card) {

    }

    @Override
    public void upDateCard(Card card) {

    }

    @Override
    public void deleteCard(Card card) {

    }
}
