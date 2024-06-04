package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> placeOfTheBooks = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("Potter", "Royling", 2000), "23a");
        addBook(new Book("Shprotter", "YOling", 1998), "66l");
        addBook(new Book("Potret", "ingRoyl", 2015), "34d");

        searchBook(new Book("Shprotter", "YOling", 1998));
        listAllBookAndPlace();
    }


    static void addBook(Book book, String place) {    // добавление новой книги и её местонахождения в библиотеке;
        placeOfTheBooks.put(book, place);
    }

    static void removeBook(Book book) {    // удаление книги по её названию, автору и году издания;
        placeOfTheBooks.remove(book);
    }

    static void searchBook(Book book) {  //поиск книги и вывода информации
        for (var mapPlaceAndBook : placeOfTheBooks.entrySet()) {
            if (mapPlaceAndBook.getKey().equals(book)) {
                System.out.println(mapPlaceAndBook.getValue());
            }
        }
        //или
        //System.out.println(placeOfTheBooks.get(book));

        //или
//        for (var mapPlaceAndBook:placeOfTheBooks.entrySet()) {
//            if (mapPlaceAndBook.getKey().getTitle().equals(book.getTitle()) & mapPlaceAndBook.getKey().getAuthors().equals(book.getAuthors()) & mapPlaceAndBook.getKey().getYear() == book.getYear()){
//                System.out.println(mapPlaceAndBook.getValue());
//            }
//        }
    }

    static void listAllBookAndPlace() {    // вывод списка всех книг и их местонахождения в библиотеке.
        System.out.println(placeOfTheBooks);
    }
}
