package faang.school.godbless.BJS2_19288;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    //местонахождение книги в библиотеке, определяется по первой букве автора
    private static Map<Book, String> libraryBooks = new HashMap<>();

    private static void addBookToLibrary(Book book) {
        String location = book.getAuthor().substring(0, 1).toUpperCase();
        libraryBooks.put(book, location);
    }

    private static void removeBookFromLibrary(String title, String author, int year) {
        libraryBooks.remove(new Book(title, author, year));
    }

    private static void searchBookLocation(String title, String author, int year) {
        String searchResponce = libraryBooks.get(new Book(title, author, year));
        if (Objects.nonNull(searchResponce)) {
            System.out.println("Location: " + searchResponce);
        } else {
            System.out.println("Not found :(");
        }
    }

    private static void viewAllBooks() {
        libraryBooks.forEach((book, location) -> System.out.println("Location: " + location + "\t\t" + book));
        System.out.println();
    }

    public static void main(String[] args) {
        addBookToLibrary(new Book("The Dragon's Roar", "Maester Aemon", 297));
        addBookToLibrary(new Book("Winter's Fury", "Archmaester Marwyn", 299));
        addBookToLibrary(new Book("The Iron Throne", "Septon Barth", 305));
        addBookToLibrary(new Book("Sands of Dorne", "Nymeria Sand", 298));
        addBookToLibrary(new Book("The Wolf's Howl", "Bran Stark", 301));
        addBookToLibrary(new Book("Shadow Over the Wall", "Benjen Stark", 296));
        addBookToLibrary(new Book("Fire and Blood", "Archmaester Gyldayn", 290));
        addBookToLibrary(new Book("The Last Dragon", "Aegon Targaryen", 300));
        addBookToLibrary(new Book("A Song of Ice", "Jon Snow", 302));
        addBookToLibrary(new Book("A Dance of Shadows", "Arya Stark", 303));
        viewAllBooks();

        removeBookFromLibrary("A Dance of Shadows", "Arya Stark", 303);
        viewAllBooks();

        searchBookLocation("A Song of Ice", "Jon Snow", 302);
        searchBookLocation("A Dance of Shadows", "Arya Stark", 303);


    }


}

