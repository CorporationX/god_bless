package school.faang;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
public class Book {
    private String title;
    private String author;
    private int year;
    public static Map<Book, String> library;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public static void putBook(String title, String author, String location, int year) {
        Book newBook = new Book(title, author, year);
        String hashValue = location;
        library.put(newBook, hashValue);
        System.out.println("Книга успешно добавлена в библиотеку");
    }

    public static void existBook(String title, String author, int year) {
        Book existBook = new Book(title, author, year);
        System.out.println("Ваша книга - " + title + ", " + "за авторством: " + author +
                " " + year + " " + "года" + " " + "располагается на " +
                library.get(existBook));
    }

    public static void removeBook(String title, String author, int year) {
        Book existBook = new Book(title, author, year);
        library.remove(existBook);
        System.out.println("Книга успешно удалена");
    }

    public static void displayAllBooks() {
        for (Map.Entry<Book, String> entryPair : library.entrySet()) {
            System.out.println(entryPair.getKey() + entryPair.getValue());
        }
    }

    public static void main(String[] args) {
        library = new HashMap<>();
        putBook("Дурак", "Достоевский", "1 полка", 1954);
        putBook("Датчанин", "Мордвинов", "3 полка", 1920);
        putBook("Дурак", "Достоевский", "1 полка", 1900);
        existBook("Придурок", "Мордвинов", 1920);
        removeBook("Придурок", "Мордвинов", 1920);
        existBook("Придурок", "Мордвинов", 1920);
        displayAllBooks();

    }

    @Override
    public String toString() {
        return "Книга - " + this.getTitle() + ", за авторством - " + this.getAuthor() +
                ", " + this.getYear() + " года расположена: ";
    }

    @Override
    public int hashCode() {
        int hashTitle = (title != null) ? title.hashCode() : 1;
        int hashAuthor = (author != null) ? author.hashCode() : 1;
        return hashTitle * 7 * hashAuthor + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (!(this.getClass().equals(obj.getClass())))) {
            return false;
        }
        Book book = (Book) obj;
        return ((year == book.year) && (Objects.equals(title, book.title))
                && (Objects.equals(author, book.author)));
    }
}
