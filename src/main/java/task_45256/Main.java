package task_45256;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Book, String> booksLocation = new HashMap<>();

        addBooksInformation(booksLocation);
    }

    private static void addBooksInformation(HashMap<Book, String> booksLocation) {
        booksLocation.put(new Book("Властелин колец", "Джон Р. Р. Толкин", 1954), "1");
        booksLocation.put(new Book("Гордость и предубеждение", "Джейн Остин", 1813), "1");
        booksLocation.put(new Book("Тёмные начала", "Филип Пулман", 1995), "2");
        booksLocation.put(new Book("Автостопом по галактике", "Дуглас Адамс", 1979), "1");
        booksLocation.put(new Book("Гарри Поттер и Кубок огня", "Джоан Роулинг", 2000), "3");
    }
}
