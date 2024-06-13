package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

import static faang.school.godbless.Book.addBook;
import static faang.school.godbless.Book.allListBook;
import static faang.school.godbless.Book.findBook;
import static faang.school.godbless.Book.removeBook;

public class Application {
    public static void main(String[] args) {

        Map<Book , String> library = new HashMap<>();

        Book firstBook = new Book("Война и мир", "Лев Толстой", 1869);
        addBook(library, firstBook, "Полка 1, Полка 2");

        Book secondBook = new Book("Преступление и наказание", "Федор Достоевский", 1866);
        addBook(library, secondBook, "Полка 3");

        Book thirdBook = new Book("Евгений Онегин", "Александр Пушкин", 1840);
        addBook(library, thirdBook, "Полка 4, полка 5");

        //removeBook(library,"Преступление и наказание","Федор Достоевский",1866);

        findBook(library, "Евгений Онегин", "Александр Пушкин", 1840);

        allListBook(library);

    }
}