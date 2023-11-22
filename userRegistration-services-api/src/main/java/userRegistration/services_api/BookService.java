package userRegistration.services_api;

import userRegistration.domain.Book;

import java.util.Collection;

public interface BookService {
    Collection<Book> readBooks();
}
