package school.faang.BJS2_59115;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class LibrarySystem {
    private static HashMap<Book, String> books = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public static String findBook(String title, String author, int year) {
        if (books.containsKey(new Book(title, author, year))) {
            return books.get(new Book(title, author, year));
        }

        /////////////////////// Вариант Номер 2 ////////////////////////
//        for (Map.Entry<Book, String> entry : books.entrySet()){
//            if (entry.getKey().getTitle().equals(title) &&  entry.getKey().getAuthor().equals(author) && entry.getKey().getYear() == year){
//                return entry.getValue();
//            }
//        }

        return "Book not found";
    }

    public static void printAllBooks() {
        books.forEach((k, v) -> System.out.println(k + " " + v));
    }

}
