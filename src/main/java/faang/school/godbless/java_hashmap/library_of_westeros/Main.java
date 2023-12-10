package faang.school.godbless.java_hashmap.library_of_westeros;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    private static Map<Book, String> bookMap = new HashMap<>();

    static {
        bookMap.put(new Book("Гордость и предубеждение", "Джейн Остен", 1813), "103");
        bookMap.put(new Book("Улисс", "Джеймс Джойс", 1922), "104");
        bookMap.put(new Book("Моби Дик", "Герман Мелвилл", 1851), "105");
        bookMap.put(new Book("Большие надежды", "Чарльз Диккенс", 1861), "106");
        bookMap.put(new Book("Властелин колец", "Дж. Р. Р. Толкин", 1954), "107");
        bookMap.put(new Book("Алиса в Стране чудес", "Льюис Кэрролл", 1865), "109");
        bookMap.put(new Book("К востоку от Эдема", "Джон Стейнбек", 1952), "110");
    }

    public static void main(String[] args) {
        add(new Book("Ловец в жите", "Джером Д. Сэлинджер", 1951), "111");
        remove(new Book("Властелин колец", "Дж. Р. Р. Толкин", 1954));
        search("Большие надежды", "Чарльз Диккенс", 1861);
        printBooks();
    }

    static void add(Book book, String location) {
        if (book == null || location == null) throw new IllegalArgumentException("args is null");
        bookMap.put(book, location);
    }

    static void remove(Book book) {
        if (book == null) throw new IllegalArgumentException("args is null");
        bookMap.remove(book);

//        for (Iterator<Map.Entry<Book, String>> it = bookMap.entrySet().iterator(); it.hasNext(); ) {
//            Map.Entry<Book, String> entry = it.next();
//            if (entry.getKey().equals(book)) {
//                it.remove();
//                break;
//            }
//        }

    }


    static void search(String title, String author, int year) {

        String location = bookMap.get(new Book(title, author, year));

        if (location == null) {
            System.out.println("Book not found");
        } else {
            System.out.println("Book location: " + location);
        }



// Если первый способ не подойдет
//        Book book = null;
//        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
//            if (entry.getKey().getAuthor().equals(author) && entry.getKey().getTitle().equals(title) && entry.getKey().getYear() == year) {
//                book = entry.getKey();
//                break;
//            }
//        }
//
//        if (book == null) {
//            System.out.println("Book not found");
//        } else {
//            System.out.println("Book location: " + bookMap.get(book));
//        }


    }


    static void printBooks() {
        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
            System.out.println(entry.getKey() + ", location: " + entry.getValue());
        }
    }


}
