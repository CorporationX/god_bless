package school.faang.bjs2_86045;

import static school.faang.bjs2_86045.LibrarySystem.addBook;
import static school.faang.bjs2_86045.LibrarySystem.findBook;
import static school.faang.bjs2_86045.LibrarySystem.printAllBooks;
import static school.faang.bjs2_86045.LibrarySystem.removeBook;

public class Main {
    public static void main(String[] args) {

        addBook("Book1", "author1", 1999, "shelf1");
        addBook("Book2", "author2", 1998, "shelf2");
        addBook("Book3", "author3", 1993, "shelf3");
        addBook("Book4", "author4", 1995, "shelf4");
        addBook("Book5", "author5", 1978, "shelf4");
        addBook("Book6", "author6", 1986, "shelf6");
        addBook("Book7", "author7", 1989, "shelf6");
        addBook("Book8", "author8", 1990, "shelf3");

        removeBook("Book5", "author5", 1978);
        findBook("Book4", "author4", 1995);
        printAllBooks();
    }
}
