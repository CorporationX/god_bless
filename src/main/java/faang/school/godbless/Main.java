package faang.school.godbless;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> placeOfTheBooks = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("Potter", "Royling", 2000), "23a");
        addBook(new Book("Shprotter", "YOling", 1998), "66l");
        addBook(new Book("Potret", "ingRoyl", 2015), "34d");

        System.out.println(searchBook(new Book("Shprotter", "YOling", 1998)));
        listAllBookAndPlace();
    }

    // добавление новой книги и её местонахождения в библиотеке;
    static void addBook(Book book, String place) {
        placeOfTheBooks.put(book, place);
    }

    // удаление книги по её названию, автору и году издания;
    static void removeBook(Book book) {
        placeOfTheBooks.remove(book);
    }

    //поиск книги и вывода информации
    static String searchBook(@NonNull Book book) {
        if (!placeOfTheBooks.containsKey(book)){
            throw new NullPointerException("Такой книги нет");
        }
        return placeOfTheBooks.get(book);
    }

    // вывод списка всех книг и их местонахождения в библиотеке.
    static void listAllBookAndPlace() {
        System.out.println(placeOfTheBooks);
    }
}
