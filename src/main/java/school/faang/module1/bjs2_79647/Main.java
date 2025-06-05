package school.faang.module1.bjs2_79647;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem(new HashMap<>());
        library.addBook("Java Programming", "John Smith", 2020, "Location A1");
        library.addBook("Effective Java", "Joshua Bloch", 2018, "Location B2");
        library.addBook("Clean Code", "Robert Martin", 2008, "Location C3");
        library.addBook("Clean Code", "Robert Martin", 2008, "Location C4");
        library.findBook("Effective Java", "Joshua Bloch", 2018);
        library.findBook("Spring in Action", "Craig Walls", 2022);
        library.removeBook("Java Programming", "John Smith", 2020);
        library.removeBook("Java Programming", "John Smith", 2020);
        library.printAllBooks();
    }
}
