package controller;


import module.Book;
import module.Card;
import module.Student;
import service.bookService.BookService;
import service.cardService.CardService;
import service.studentService.StudentSetvice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.util.List;

@WebServlet(name = "CardServlet", value = "/CardServlet")
public class CardServlet extends HttpServlet {
    private CardService cardService = new CardService();
    private BookService bookService = new BookService();
    private StudentSetvice studentSetvice = new StudentSetvice();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showBookList":
                showAllBook(request, response);
                break;
            case "borrow":
                showBorrowForm(request, response);
                break;
            case "return":
                showReturnForm(request, response);
            default:
                listCardShow(request, response);
        }
    }

    private void showReturnForm(HttpServletRequest request, HttpServletResponse response) {
        int cardID = Integer.parseInt(request.getParameter("id"));
        Card card = cardService.selectCardByID(cardID);
        request.setAttribute("card", card);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/returnBook.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showBorrowForm(HttpServletRequest request, HttpServletResponse response) {
        int bookID = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.selectBookByID(bookID);
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/loanBook.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void showAllBook(HttpServletRequest request, HttpServletResponse response) {
        List<Book> bookList = bookService.showAllBook();
        request.setAttribute("bookList", bookList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/listBook.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listCardShow(HttpServletRequest request, HttpServletResponse response) {
        List<Card> cardList = cardService.selectAllCard();
        request.setAttribute("cardlist", cardList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/listCard.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                borrowBook(request, response);
                break;
            case "return":
                returnBook(request, response);
            default:
                listCardShow(request, response);
                break;
        }
    }

    private void returnBook(HttpServletRequest request, HttpServletResponse response) {
        int cardID = Integer.parseInt(request.getParameter("id"));
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        cardService.updateCard(cardID);
        bookService.returnBook(bookID);
        List<Card> cardList = cardService.selectAllCard();
        request.setAttribute("cardlist", cardList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/listCard.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void borrowBook(HttpServletRequest request, HttpServletResponse response) {
        int bookID = Integer.parseInt(request.getParameter("id"));
        int studentID = Integer.parseInt(request.getParameter("studentID"));
        String cardCode = request.getParameter("cardCode");
        String borrowDate = request.getParameter("borrowDate");
        String returnDate = request.getParameter("returnDate");
        Book book = bookService.selectBookByID(bookID);
        Student student = studentSetvice.selectStudentByID(studentID);
        boolean status = true;
        Card card = new Card(cardCode, book, student, status, borrowDate, returnDate);
        cardService.createCard(card);
        bookService.borrowBook(bookID);
        List<Card> cardList = cardService.selectAllCard();
        request.setAttribute("cardlist", cardList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/listCard.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
