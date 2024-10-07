package school.faang.BJS2_33139;

import java.util.HashMap;
import java.util.Map;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Map<Book, String> library = new HashMap<>();

        library.put(new Book("Война и мир", "Лев Толстой", 1869), "Шкаф 1, Полка 1, Книга 1");
        library.put(new Book("Преступление и наказание", "Фёдор Достоевский", 1866), "Шкаф 1, Полка 1, Книга 2");
        library.put(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967), "Шкаф 1, Полка 1, Книга 3");
        library.put(new Book("Анна Каренина", "Лев Толстой", 1877), "Шкаф 1, Полка 2, Книга 1");
        library.put(new Book("Идиот", "Фёдор Достоевский", 1869), "Шкаф 1, Полка 2, Книга 2");
        library.put(new Book("Евгений Онегин", "Александр Пушкин", 1833), "Шкаф 1, Полка 2, Книга 3");
        library.put(new Book("Дубровский", "Александр Пушкин", 1841), "Шкаф 2, Полка 1, Книга 1");
        library.put(new Book("Обломов", "Иван Гончаров", 1859), "Шкаф 2, Полка 1, Книга 2");
        library.put(new Book("Тихий Дон", "Михаил Шолохов", 1940), "Шкаф 2, Полка 1, Книга 3");
        library.put(new Book("Отцы и дети", "Иван Тургенев", 1862), "Шкаф 2, Полка 2, Книга 1");
        library.put(new Book("Мёртвые души", "Николай Гоголь", 1842), "Шкаф 2, Полка 2, Книга 2");
        library.put(new Book("Доктор Живаго", "Борис Пастернак", 1957), "Шкаф 3, Полка 1, Книга 1");
        library.put(new Book("Белая гвардия", "Михаил Булгаков", 1925), "Шкаф 3, Полка 1, Книга 2");
        library.put(new Book("Записки из подполья", "Фёдор Достоевский", 1864), "Шкаф 3, Полка 1, Книга 3");
        library.put(new Book("Герой нашего времени", "Михаил Лермонтов", 1840), "Шкаф 3, Полка 2, Книга 1");

        printAllBooks(library);

        addToLibrary(library, new Book("Три товарища", "Эрих Мария Ремарк", 1936), "Шкаф 3, Полка 3, Книга 1");

        printAllBooks(library);

        System.out.println("Книга находится: " + findInLibrary(library, "Герой нашего времени","Михаил Лермонтов",1840));

        System.out.println("Книга находится: " + findInLibrary(library, "Герой нашего времени","Михаил Лермонтов",1845));

        removeFromLibrary(library, "Герой нашего времени","Михаил Лермонтов",1840);
        printAllBooks(library);

    }

    public static boolean addToLibrary(Map<Book, String> library, Book book, String address) {

        if(library != null && book != null && address != null) {
            library.putIfAbsent(book, address);
            return true;
        }
        return false;
    }

    public static boolean removeFromLibrary(Map<Book, String> library, String name, String author, int year) {

        if(library != null && name != null && author != null && year > 0) {
            return library.remove(new Book(name, author, year)) != null;
        }
        return false;
    }

    public static String findInLibrary(Map<Book, String> library, String title, String author, int year) {
        if (library == null) {
            return "Library is null";
        }

        if(title == null && author == null && year <= 1000) {
            return "Wrong params";
        }

        String address = library.get(new Book(title, author, year));
        if(address != null) {
            return address;
        }
        return "Book not found";

    }

    public static void printAllBooks(Map<Book, String> library) {
        if(library == null) {
            System.out.println("Library is null");
            return;
        }

        if(library.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }
        System.out.println("===================Printing all books===================");

        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + "Book Address" + entry.getValue());
        }

        System.out.println("===================End of library===================\n");
    }

}
