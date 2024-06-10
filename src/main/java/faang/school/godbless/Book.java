package faang.school.godbless;
import javax.xml.stream.FactoryConfigurationError;
import java.util.Map;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private Integer year;

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public static void addBook(Map<Book, String> library, Book book, String location) {
        library.put(book, location);
    }

    public static void findBook(Map<Book, String> library, String title, String author, Integer year) {
        for (Book book : library.keySet()) {
            if (book.title.equals(title) && book.author.equals(author) && book.year.equals(year)) {
                System.out.println("Нашли книжку");
                System.out.println("Title " + book.author);
                System.out.println("Year " + book.year);
                System.out.println("Book " + book.title);
                System.out.println("Book location " + library.get(book));
                return;
            }
        }
        System.out.println("Ничего не нашлось");
    }

    public static void removeBook(Map<Book, String> library, String title, String author, Integer year) {
        Book bookToRemove = null;
        for (Book book : library.keySet()) {
            if (book.title.equals(title) && book.author.equals(author) && book.year.equals(year)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            library.remove(bookToRemove);
            System.out.println("Удалили книжечку" + bookToRemove.author);
        } else {
            System.out.println("Книжка не нашлась");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }

        if (obj.getClass() != this.getClass()){
            return false;
        }

        Book book = (Book) obj;

        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);  // вычисляет хеш код для каждого выбранного компонента
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
