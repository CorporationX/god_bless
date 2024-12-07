package school.faang.task_45336;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        var initialBooks = new HashMap<Book, String>();
        initialBooks.put(new Book("Преступление и наказание", "Достоевский", 1866), "1");
        initialBooks.put(new Book("Маленький принц", "Антуан де Сент-Экзюпери", 1943), "121");
        initialBooks.put(new Book("По ком звонит колокол", "Эрнест Хемингуэй", 1940), "19");

        var library = new LibrarySystem(initialBooks);
        library.addBook("Лолита", "Владимир Набоков", 1955, "93");
        library.addBook("Лолита", "Владимир Набоков", 1955, "93");
        library.findBook("По ком звонит колокол", "Эрнест Хемингуэй", 1940);
        library.removeBook("Преступление и наказание", "Достоевский", 1866);
        library.printAllBooks();
    }
}
