package school.faang;

import school.faang.secondTask.Book;
import school.faang.secondTask.BookManager;

public class Main {
    public static void main(String[] args) {
        vesterosLibrary();
    }

    private static void vesterosLibrary() {
        BookManager bookManager = new BookManager();
        bookManager.addBook(new Book("1984", "Джордж Оруэлл", 1949), "Полка 1");
        bookManager.addBook(new Book("Чебурашка", "Успенский", 1975), "Полка 2");
        bookManager.addBook(new Book("Незнайка", "Носов", 1979), "Полка 3");
        bookManager.addBook(new Book("Незнайка", "Носов", 1979), "Полка 4");
        bookManager.listAllBooks();

        bookManager.findBook(new Book("1984", "Джордж Оруэлл", 1949));

        bookManager.removeBook(new Book("1984", "Джордж Оруэлл", 1949));
        bookManager.removeBook(new Book("1984", "Джордж Оруэлл", 1949));

        bookManager.listAllBooks();
    }
}
