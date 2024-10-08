package school.faang.BJS233103;

import java.util.Map;

public interface BookService {

    Map<Book, String> getBooks();

    void addBook(String title, String author, int year);

    void deleteBookByTitle(String title, String author, int year);

    void findBook(String title, String author, int year);

    void printBooks();

    String generatePlace();
}
