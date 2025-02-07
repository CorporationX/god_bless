package bjs257097;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        generateTestData();
    }

    private static void generateTestData() {
        LibrarySystem librarySystem = new LibrarySystem();
        Map<Book, String> booksToPlaces = librarySystem.getBooksToPlaces();
        booksToPlaces.put(new Book("Modern Java in Action", "Raoul-Gabriel Urma", 2018), "floor1");
        booksToPlaces.put(new Book("Optimizing Java", "Ben Evans", 2018), "floor2");
        booksToPlaces.put(new Book("Head First Java", "Bert Bates", 2018), "floor3");
        booksToPlaces.put(new Book("Head First Design Patterns", "Eric Freeman", 2004), "floor4");
        booksToPlaces.put(new Book("Effective Java", "Joshua Bloch", 2008), "floor5");
        booksToPlaces.put(new Book("Java Concurrency in Practice", "Joshua Bloch", 2006), "floor6");
        booksToPlaces.put(new Book("Java Generics and Collections", "Philip Wadler", 2006), "floor7");
        booksToPlaces.put(new Book("Java Puzzlers", "Joshua Bloch", 2005), "floor8");

        System.out.printf("Size booksToPlaces before adding book: %d %n", booksToPlaces.size());
        librarySystem.addBook("SQL: The Ultimate Beginners Guide", "Steve Tale", 2016, "floor1");
        System.out.printf("Size booksToPlaces after adding book: %d %n", booksToPlaces.size());

        System.out.printf("Size booksToPlaces before removing book: %d %n", booksToPlaces.size());
        librarySystem.removeBook("SQL: The Ultimate Beginners Guide", "Steve Tale", 2016);
        System.out.printf("Size booksToPlaces after removing book: %d %n", booksToPlaces.size());

        librarySystem.findBook("Optimizing Java", "Ben Evans", 2018);

        librarySystem.printAllBooks();
    }
}
