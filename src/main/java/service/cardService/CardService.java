package service.cardService;


import config.ConnectSingleton;
import module.Book;
import module.Card;
import module.Student;
import service.bookService.BookService;
import service.studentService.StudentSetvice;

import java.sql.*;

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

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from card where status = true;");
            ResultSet rs = preparedStatement.executeQuery();
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
                cardList.add(new Card(id, cardCode, student, book, status, loanDate, backDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardList;
    }

    @Override
    public Card selectCardByID(int id) {
        Card card = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from card where card_id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String cardCode = rs.getString("card_code");
                int bookID = rs.getInt("book_id");
                Book book = bookService.selectBookByID(bookID);
                int studentID = rs.getInt("student_id");
                Student student = studentSetvice.selectStudentByID(studentID);
                boolean status = rs.getBoolean("status");
                String loanDate = rs.getString("loanDate");
                String backDate = rs.getString("backDate");
                card = new Card(id, cardCode, student, book, status, loanDate, backDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    @Override
    public void createCard(Card card) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into card (card_code,book_id,student_id,loanDate,backDate) values (?,?,?,?,?);");
            preparedStatement.setString(1, card.getCardCode());
            preparedStatement.setInt(2, card.getBook().getId());
            preparedStatement.setInt(3, card.getStudent().getId());
            preparedStatement.setDate(4, Date.valueOf(card.getLoanDate()));
            preparedStatement.setDate(5, Date.valueOf(card.getBackDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCard(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update card set status = false where card_id = ?;");
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCard(Card card) {

    }
}
