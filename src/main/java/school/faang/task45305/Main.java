package school.faang.task45305;

import school.faang.task45305.model.Book;
import school.faang.task45305.service.LibrarySystem;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Book, String> libraryBooks = new HashMap<>();

        libraryBooks.put(new Book("Война и мир", "Лев Толстой", 1869), "Bookshelf 1, Shelf 7, Place 123");
        libraryBooks.put(new Book("Улисс", "Джеймс Джойс", 1922), "Bookshelf 10, Shelf 1, Place 43");
        libraryBooks.put(new Book("Лолита", "Владимир Набоков", 1955), "Bookshelf 5, Shelf 3, Place 673");
        libraryBooks.put(new Book("Шум и ярость", "Уильям Фолкнер", 1929), "Bookshelf 2, Shelf 2, Place 22");
        libraryBooks.put(new Book("Человек-невидимка", "Ральф Эллисон", 1952), "Bookshelf 6, Shelf 8, Place 3");
        libraryBooks.put(new Book("На маяк", "Вирджиния Вульф", 1927), "Bookshelf 3, Shelf 1, Place 77");
        libraryBooks.put(new Book("_ллиада и Одиссея", "Гомер", -750), "Bookshelf 2, Shelf 9, Place 97");

        LibrarySystem library = new LibrarySystem(libraryBooks);
        library.printAllBooks();

        library.addBook("Гордость и предубеждение", "Джейн Остен", 1813, "Bookshelf 7, Shelf 6, Place 44");
        library.addBook("Божественная комедия", "Данте Алигьери", 1321, "Bookshelf 3, Shelf 1, Place 42");
        library.printAllBooks();

        System.out.println("Удаление книг: ");
        if (library.removeBook("На маяк", "Вирджиния Вульф", 1927)) {
            System.out.println("Книга успешно удалена");
        } else {
            System.out.println("Книга не найдена для удаления");
        }

        if (library.removeBook("Шум и ярость", "Уильям Фолкнер", 1929)) {
            System.out.println("Книга успешно удалена");
        } else {
            System.out.println("Книга не найдена для удаления");
        }
        if (library.removeBook("Государь", "Николо Макиавелли", 1532)) {
            System.out.println("Книга успешно удалена");
        } else {
            System.out.println("Книга не найдена для удаления");
        }

        library.printAllBooks();

        System.out.println("Результаты поиска: ");
        String searchResult;
        searchResult = library.findBook("Улисс", "Джеймс Джойс", 1922);
        System.out.println(searchResult);
        searchResult = library.findBook("Война и мир", "Лев Толстой", 1869);
        System.out.println(searchResult);
        searchResult = library.findBook("Путешествия Гулливера", "Джонатан Свифт", 1726);
        System.out.println(searchResult);

    }
}
