package userRegistration.domain;

import java.util.Objects;

public class Book {
    private long bookId;
    private String title;
    private int publicationYear;
    private int authorId;

    public Book(){

    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", authorId=" + authorId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && publicationYear == book.publicationYear && authorId == book.authorId && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, publicationYear, authorId);
    }

    public Book(long bookId, String title, int publicationYear, int authorId) {
        this.bookId = bookId;
        this.title = title;
        this.publicationYear = publicationYear;
        this.authorId = authorId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
