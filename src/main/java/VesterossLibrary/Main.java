package VesterossLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static final HashMap<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        putBookToLibrary("1984","G.Oruwell", 1949,"1");
        putBookToLibrary("Fahrenheit 451","R.Bradbury", 1953,"1");
        putBookToLibrary("Clean Code","R.Martin", 2012,"2");
        putBookToLibrary("Spring in Action","C.Walls", 2005,"2");
        putBookToLibrary("The Shining","S.King", 1977,"3");

        printInfoAboutAllBooks();

        deleteBook("Spring in Action","C.Walls", 2005);
        printInfoAboutAllBooks();

        getInfoAboutBook("Spring in Action","C.Walls", 2005);

        getInfoAboutBook("The Shining","S.King", 1977);

    }

    public static Book putBookToLibrary(String title, String author, int year, String shelf) {
        Book newBook = new Book(title, author, year);
        library.put(newBook, shelf);
        return newBook;
    }
    public static Book putBookToLibrary(Book book, String shelf) {
        library.put(book, shelf);
        return book;
    }

    public static void deleteBook(String title, String author, int year) {
        Book targetBook = new Book(title, author, year);
        library.remove(targetBook);
    }

    public static void getInfoAboutBook(String title, String author, int year) {
        Book targetBook = new Book(title, author, year);
        if (!library.containsKey(targetBook)) {
            System.out.println("В библиотеке нет такой книги");
        }else{
            System.out.printf("Книга %s лежит на полке %s%n", targetBook, library.get(targetBook));
        }
    }

    public static void printInfoAboutAllBooks() {
        HashMap<String, List<Book>> groupingMap = new HashMap<>();
        for (Book book : library.keySet()) {
            if (!groupingMap.containsKey(library.get(book))) {
                groupingMap.put(library.get(book), new ArrayList<>());
            }
            groupingMap.get(library.get(book)).add(book);
        }
        StringBuilder sb = new StringBuilder();
        for (String shelf : groupingMap.keySet()) {
            sb.append("Полка #%s: ".formatted(shelf));
            for (Book book : groupingMap.get(shelf)) {
                sb.append(book.toString()).append(", ");
            }
            sb.replace(sb.length()-2, sb.length(), "");
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
