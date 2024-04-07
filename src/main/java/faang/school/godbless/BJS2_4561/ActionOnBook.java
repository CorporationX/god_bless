package faang.school.godbless.BJS2_4561;

import java.util.Map;

public class ActionOnBook {
    public static void addNewBook(String title, String author, int year, Map<Book, String> bookMap, String position) {
        Book newBook = new Book(title, author, year);
        bookMap.put(newBook, position);
    }

    public static void deleteBook(Book book, Map<Book, String> bookMap) {
        bookMap.remove(book);
    }

    public static void searchBook(Book book, Map<Book, String> bookMap) {
        if (book != null && bookMap.containsKey(book)) {
            System.out.println("Книга: " + book.getTitle() + ", Расположение: " + bookMap.get(book));
        } else {
            System.out.println("Книга не найдена или передан null объект");
        }
        System.out.print("\n");
    }

    public static void printAllBook(Map<Book, String> bookMap) {
        for (Map.Entry<Book, String> book : bookMap.entrySet()) {
            System.out.println("Название: " + book.getKey().getTitle() + ", Расположение: " + book.getValue());
        }
        System.out.print("\n");
    }
}
