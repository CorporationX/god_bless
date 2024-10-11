package vesterosse.library;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public String toString() {
        return "Название: '" + title + '\'' +
                ", Автор: '" + author + '\'' +
                ", Год: " + year;
    }

    public static void addBook(Map<Book, String> map, Book book, String place) {
        map.put(book, place);
        System.out.println("Книга '" + book.title + "' добавлена в библиотеку!" + "\n");
    }

    public static void removeBook(Map<Book, String> map, String title, String author, int year) {
        map.remove(new Book(title, author, year));
        System.out.println("Вы удалили книгу '" + title + "' из библиотеки!" + "\n");
    }

    public static void searchBook(Map<Book, String> map, String title, String author, int year) {
        System.out.println("Ваша книга найдена! Она находится на полке № " + map.get(new Book(title, author, year)) + "\n");
    }

    public static void printBook(Map<Book, String> map) {
        System.out.println("Список всех книг в библиотеке:");
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", Полка № " + entry.getValue());
        }
    }
}
