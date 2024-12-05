package school.faang.bjs245335.books;

import lombok.AllArgsConstructor;
import lombok.Getter;
import school.faang.bjs245335.Book;

@Getter
@AllArgsConstructor
public enum BooksData {
    BOOK1("Java philosophy", "Bruce Eckel", 2004),
    BOOK2("Disign patterns", "four band", 2010),
    BOOK3("Voina i Mir", "Lev Tolstoy", 1867),
    BOOK4("title1", "author", 1999);

    private final String title;
    private final String author;
    private final int year;

    public Book createBook() {
        return new Book(title, author, year);
    }
}
