package faang.school.godbless.libraryOfWesteros;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> mapBooks = new HashMap<>();
        mapBooks.put(new Book("Forbidden Notebook", "Alba De Cespedes", 2023), "Shelf 21");
        mapBooks.put(new Book("Yellowface", "R.F.Kuang", 2023), "Shelf 11");
        mapBooks.put(new Book("Dune", "Frank Herbert", 1965), "Shelf 8");

        addNewBookAndLocation(mapBooks, new Book("Atomic Habits", "J. Clear", 2023), "Shelf 44");
        removeBook(mapBooks, "The women", "K. Hannah", 2024);
        findLocationOfBook(mapBooks, "Yellowface", "R.F.Kuang", 2023);
        printInformationAboutAllBooks(mapBooks);
    }

    public static void addNewBookAndLocation(Map<Book, String> mapBooks, Book newBook, String newLocation) {
        mapBooks.put(newBook, newLocation);
        System.out.println("Книга добавлена в библиотеку.");
    }

    public static void removeBook(Map<Book, String> mapBooks, String title, String author, int year) {
        Book bookNeedToRemove = new Book(title, author, year);
        if (mapBooks.containsKey(bookNeedToRemove)) {
            mapBooks.remove(bookNeedToRemove);
            System.out.println("Книга удалена из библиотеки.");
        } else {
            System.out.println("Такой книги в библиотеке нет.");
        }
    }

    public static void findLocationOfBook(Map<Book, String> mapBooks, String title, String author, int year) {
        Book bookNeedToFind = new Book(title, author, year);
        if (mapBooks.containsKey(bookNeedToFind)) {
            String neededShelf = mapBooks.get(bookNeedToFind);
            System.out.println("Данная книга находится на " + neededShelf);
        } else {
            System.out.println("Такой книги в библиотеке нет.");
        }
    }

    public static void printInformationAboutAllBooks(Map<Book, String> mapBooks) {
        for (Map.Entry<Book, String> entry : mapBooks.entrySet()) {
            System.out.println("Книга " + entry.getKey().getTitle() + ", "
                    + entry.getKey().getAuthor() + ", " + entry.getKey().getYear()
                    + " находится на " + entry.getValue());
        }
    }
}
