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

    public static void main(String[] args) {
        Map<Book, String> books = new HashMap<>();
        Book book1 = new Book("Название книги 1", "Автор книги 1", 2000);
        Book book2 = new Book("Название книги 2", "Автор книги 2", 1990);
        Book book3 = new Book("Название книги 3", "Автор книги 3", 2010);

        books.put(book1, "Полка 1");
        books.put(book2, "Полка 2");
        books.put(book3, "Полка 3");
        books.remove(book1);

        // Поиск книги
        Book searchBook = new Book("Название книги 2", "Автор книги 2", 1990);
        String location = books.get(searchBook);
        System.out.println("Местонахождение книги: " + location);

        // Вывод списка всех книг
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().getTitle() +
                    " - Местонахождение: " + entry.getValue());
        }
    }
}
