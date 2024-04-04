package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Library {
    private HashMap<Book, String> library = new HashMap<>();

    // добавление новой книги и её местонахождения в библиотеке;
    public void addBookToPlace(String bookTitle, String bookAuthor, int bookYear, String bookPlace) {
        library.put(new Book(bookTitle, bookAuthor, bookYear), bookPlace);
    }

    // удаление книги по её названию, автору и году издания;
    public void deleteByAttributes(String bookTitle, String bookAuthor, int bookYear) {
        Book bookToDelete = new Book(bookTitle, bookAuthor, bookYear);
        if (library.containsKey(bookToDelete)) {
            library.remove(bookToDelete);
        } else {
            throw new IllegalArgumentException("No such book in library");
        }
    }

    // поиск книги и вывода информации о её местонахождении в библиотеке,
    // используя название книги, автора и год издания;
    public void searchPlaceByAttributes(String bookTitle, String bookAuthor, int bookYear) {
        Book desiredBook = new Book(bookTitle, bookAuthor, bookYear);
        if (library.containsKey(desiredBook)) {
            System.out.println("Указанная книга лежит в " + library.get(desiredBook));
        } else {
            throw new IllegalArgumentException("No such book in library");
        }
    }

    // вывод списка всех книг и их местонахождения в библиотеке
    public void displayAllBooksAndPlaces() {
        Set<Map.Entry<Book, String>> booksAndPlaces = library.entrySet();
        for (Map.Entry<Book, String> bookAndPlace : booksAndPlaces) {
            System.out.println(bookAndPlace.getKey() + " lays in " + bookAndPlace.getValue());
        }
    }
}
