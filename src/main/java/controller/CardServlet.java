package controller;



import module.Book;
import module.Card;
import service.bookService.BookService;
import service.cardService.CardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CardServlet", value = "/CardServlet")
public class CardServlet extends HttpServlet {
    private CardService cardService = new CardService();
    private BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "showBookList" :
                showAllBook(request,response);
            case "borrow" :
                showBorrowForm(request,response);
            default: listCardShow(request, response);
            break;
        }
    }

    private void showBorrowForm(HttpServletRequest request, HttpServletResponse response) {
        int bookID = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.selectBookByID(bookID);
        List<Card> cardList = cardService.selectAllCard();
        request.setAttribute("cardList",cardList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/loan.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllBook(HttpServletRequest request, HttpServletResponse response) {
        List<Book> bookList = bookService.showAllBook();
        request.setAttribute("bookList",bookList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/listBook.jsp");
    }

    private void listCardShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Card> cardList = cardService.selectAllCard();
        request.setAttribute("cardlist", cardList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/listCard.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "borrow" :
                borrowBook(request,response);
            default: listCardShow(request, response);
                break;
        }
    }

    private void borrowBook(HttpServletRequest request, HttpServletResponse response) {

    }
}
}