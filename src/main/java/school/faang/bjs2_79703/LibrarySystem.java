package school.faang.bjs2_79703;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibrarySystem {
    private Map<Book, String> libraryMap;

    public void addBook(String title, String author, int year, String location) {
        libraryMap.put(new Book(title, author, year), location);
    }

    public String removeBook(String title, String author, int year) {
        if (Objects.isNull(libraryMap.get(new Book(title, author, year)))) {
            return "Book is not found";
        }
        libraryMap.remove(new Book(title, author, year));
        return String.format("Book: %s %s %s was remove",
                title, author, year);
    }

    public String findBook(String title, String author, int year) {
        if (libraryMap.get(new Book(title, author, year)) == null) {
            return "Book is not found";
        }
        return String.format("book: %s %s %s, located is: %s",
                title, author, year, libraryMap.get(new Book(title, author, year)));

    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> book : libraryMap.entrySet()) {
            System.out.printf("title: %s, author: %s, year: %s, location: %s%n",
                    book.getKey().getTitle(), book.getKey().getAuthor(), book.getKey().getYear(), book.getValue());
        }
    }
}