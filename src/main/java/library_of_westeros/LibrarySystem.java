package library_of_westeros;

import java.util.Map;

public class LibrarySystem {


    public static void addBook(String title, String author, int year, String location, Map<Book, String> mapBooks) {
        mapBooks.put(new Book(title, author, year), location);
        System.out.println("книга добавлена");
    }

    public static void removeBook(String title, String author, int year, Map<Book, String> mapBooks) {
        mapBooks.remove(findBook(title, author, year, mapBooks));
        System.out.println("Книга: " + title + " удалена");
    }

    public static Book findBook(String title, String author, int year, Map<Book, String> mapBooks) {
        Book book = new Book(title, author, year);
        if (mapBooks.get(book) == null) {
            System.out.println("Такой книги нет на полке");
        } else
            System.out.println("книга найдена и находится в " + mapBooks.get(book));
        return book;
    }
    public static void AllBooks(Map<Book, String> mapBooks){
        mapBooks.forEach((key, value) -> System.out.println("книга: " + key.getTitle() + "автора: "
                + key.getAuthor() + "находится на полке: " + value));
        }
    }

