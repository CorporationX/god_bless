package src.main.java.faang.school.godbless;

import java.util.Map;
import java.util.Objects;

import static src.main.java.faang.school.godbless.Main.map;

public class Book {
    String title;
    String author;
    int year;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }


    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    public static void addNewBook(String title, String author, int year) {
        Book newBook = new Book(title, author, year);
        int mesto = search(map);
        map.put(newBook, "#" + mesto);
    }

    private static int search(Map<Book, String> map) {
        int mesto = 1;
        while (map.containsValue("#" + mesto)) {
            mesto++;
        }
        return mesto;
    }

    public static void deleteBook(String title, String author, int year) {
        Book bookToRemove = null;
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            if (entry.getKey().getTitle().equals(title) &&
                    entry.getKey().getAuthor().equals(author) &&
                    entry.getKey().getYear() == year) {
                bookToRemove = entry.getKey();
                break;
            }
        }
        map.remove(bookToRemove);

    }

    public static void SearchAndPrintBook(String title, String author, int year) {
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            Book book = entry.getKey();
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getYear() == year) {
                System.out.println(book);
            }
        }
    }
}


