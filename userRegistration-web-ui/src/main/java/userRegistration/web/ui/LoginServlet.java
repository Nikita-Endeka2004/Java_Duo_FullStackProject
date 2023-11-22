package userRegistration.web.ui;

import userRegistration.domain.Author;
import userRegistration.domain.Book;
import userRegistration.domain.dto.AppUserViewDto;
import userRegistration.services.AuthorServiceImpl;
import userRegistration.services.BookServiceImpl;
import userRegistration.services.UserServiceImpl;
import userRegistration.services_api.AuthorService;
import userRegistration.services_api.BookService;
import userRegistration.services_api.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private AuthorService authorService = new AuthorServiceImpl();
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/userRegistration/index");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        AppUserViewDto user = userService.login(email, password);
        HttpSession session = req.getSession(true);
        Collection<Author> authors = authorService.readAuthors();
        Collection<Book> books = bookService.readBooks();
        session.setAttribute("authors", authors);
        session.setAttribute("books", books);
        session.setAttribute("user", user);
        resp.sendRedirect("/userRegistration/index");
    }
}
