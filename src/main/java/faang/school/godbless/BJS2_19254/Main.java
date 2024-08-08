package faang.school.godbless.BJS2_19254;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    static Map<Book, String> booksCatalog = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("Война и мир", "Лев Толстой", 2024), 1);
        addBook(new Book("Защита Лужина", "Владимир Набоков", 2020), 1);
        addBook(new Book("Clean Code", "Robert Martin", 2022), 2);
        addBook(new Book("The Philosophy of Java", "Bruce Eckel", 2022), 2);
        addBook(new Book("Древний", "Сергей Тармашев", 2019), 3);
        addBook(new Book("Фальшивые зеркала", "Сергей Тармашев", 2018), 3);
        findAll();
        removeBook("Clean Code", "Robert Martin", 2022);
        System.out.println("---------");
        findAll();
        System.out.println("----------");
        findBook("Древний", "Сергей Тармашев", 2019);
        findBook("Древний1", "Сергей Тармашев", 2019);
    }

    public static void addBook(Book book, int shelfBookNumber) {
        String shelfNumber = "Полка " + shelfBookNumber;
        booksCatalog.put(book, shelfNumber);
    }

    public static void removeBook(String title, String author, int year) {
        booksCatalog.remove(new Book(title, author, year));
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        Optional<String> shelf = Optional.ofNullable(booksCatalog.get(book));
        if (shelf.isPresent()) {
            System.out.println("Книга " + title
                    + " находится на " + shelf.get());
        } else {
            System.out.println("Книга не найдена ни на одной полке");
        }
    }

    public static void findAll() {
        booksCatalog.forEach((book, bookshelfNumber) ->
                System.out.println(book.getTitle() + ": " + bookshelfNumber));
    }
}


