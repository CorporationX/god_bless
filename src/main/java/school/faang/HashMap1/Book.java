package school.faang.HashMap1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }


    public static void addBook(Book newBook, String place, Map<Book, String> library){
        library.put(newBook, place);
    }


    public static void deleteBook(String title, String author, int year, Map<Book, String> library){
        library.remove(new Book(title, author, year));
    }


    public static Book searchBook(String title, String author, int year, Map<Book, String> library){
        Book book = new Book(title, author, year);
        if(library.containsKey(book)){
            return book;
        }
        return null;
    }


    public static void printBook(Book book, Map<Book, String> library) {
        if (book != null) {
            System.out.println(book.getTitle() + " находится на полке №" + library.get(book));
        } else {
            System.out.println("Книга не найдена");
        }
    }


    public static void printBooksInfo(Map<Book, String> library){
        for (Map.Entry<Book, String> entry: library.entrySet()){
            printBook(entry.getKey(), library);
        }
    }
}
