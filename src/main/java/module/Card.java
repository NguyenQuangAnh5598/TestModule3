package module;

import service.bookService.BookService;

public class Card {
private int id;
private String cardCode;
private Student student;
private Book book;
private boolean status;
private String loanDate;
private String backDate;

    public Card() {
    }

    public Card(int id, String cardCode, boolean status, String loanDate, String backDate) {
        this.id = id;
        this.cardCode = cardCode;
        this.status = status;
        this.loanDate = loanDate;
        this.backDate = backDate;
    }

    public Card(int id, String cardCode, Student student, Book book, boolean status, String loanDate, String backDate) {
        this.id = id;
        this.cardCode = cardCode;
        this.student = student;
        this.book = book;
        this.status = status;
        this.loanDate = loanDate;
        this.backDate = backDate;
    }

    public Card(String cardcode, Book book, Student student, boolean status, String loanDate, String backDate) {
        this.cardCode = cardcode;
        this.book = book;
        this.student = student;
        this.status = status;
        this.loanDate = loanDate;
        this.backDate = backDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getBackDate() {
        return backDate;
    }

    public void setBackDate(String backDate) {
        this.backDate = backDate;
    }
}
