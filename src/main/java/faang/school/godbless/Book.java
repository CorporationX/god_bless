package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && year == book.year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}

class Main {
    private static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("Название книги 1", "Автор книги 1", 2000);
        Book book2 = new Book("Название книги 2", "Автор книги 2", 1990);
        Book book3 = new Book("Название книги 3", "Автор книги 3", 2010);

        books.put(book1, "Полка 1");
        books.put(book2, "Полка 2");
        books.put(book3, "Полка 3");
    }

    public static void addBook(Book book, String place) {
        books.put(book, place);
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            books.remove(book);
            System.out.println("Книга удалена");
        } else {
            System.out.println("Ошибка удаления");
        }
    }

    public static void searchBook(String title, String author, int year) {
        Book searchBook = new Book("Название книги 2", "Автор книги 2", 1990);
        String location = books.get(searchBook);
        System.out.println("Местонахождение книги: " + location);
    }

    public static void infoBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " - Местонахождение: " + entry.getValue());
        }
    }
}

