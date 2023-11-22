package userRegistration.services_api;

import userRegistration.domain.Author;

import java.util.Collection;

public interface AuthorService {
    Collection<Author> readAuthors();
}
