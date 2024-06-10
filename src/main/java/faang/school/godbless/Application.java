package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

import static faang.school.godbless.Book.addBook;
import static faang.school.godbless.Book.findBook;
import static faang.school.godbless.Book.removeBook;

public class Application {
    public static void main(String[] args) {

        Map<Book, String> library = new HashMap<>();

        Book book1 = new Book("The song of ice and fire", "J. Martin", 2008);

        Book book2 = new Book("Prisoner of Azkaban", "J. Rowling", 2005);


        addBook(library, book1, "1");
        addBook(library, book2, "2");


        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        findBook(library, "Prisoner of Azkaban", "J. Rowling", 2005);
        removeBook(library, "Prisoner of Azkaban", "J. Rowling", 2005);


        System.out.println(library);
    }
}