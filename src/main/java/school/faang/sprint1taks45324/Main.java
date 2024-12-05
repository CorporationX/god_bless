package school.faang.sprint1taks45324;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Sandora", "Masa", 2000);
        Book book2 = new Book("Apple", "Misa", 2001);
        Book book3 = new Book("X", "Musa", 2002);
        Book book4 = new Book("Mercedec", "Mata", 2003);

        HashMap<Book, String> book = new HashMap<>() {{
            put(book1, "22");
            put(book2, "33");
            put(book3, "44");
            put(book4, "55");
        }};

        LibrarySystem libSys = new LibrarySystem(book);
        libSys.addBook("hoohoho", "Santa", 2025, "77");
        libSys.findBook("1231323321", "Santa", 2025);
    }
}