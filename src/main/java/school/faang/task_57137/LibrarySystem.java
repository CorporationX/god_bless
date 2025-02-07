package school.faang.task_57137;

import java.util.HashMap;

public class LibrarySystem {
    HashMap<Book, String> bookLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        bookLocation.put(newBook, location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        bookLocation.remove(bookToRemove);
    }

    public void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);

        if (bookLocation.get(bookToFind) != null) {
            System.out.printf("\nНомер позиции выбранной книги: %s\n", bookLocation.get(bookToFind));
        } else {
            System.out.println("\nНомер позиции выбранной книги не найден");
        }
    }

    public void printAllBooks() {
        System.out.println("\nСписок книг в библиотеке:");
        for (HashMap.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.printf("\n\tНазвание произведения: %s\n\tНомер позиции в библиотеке: %s\n",
                    entry.getKey().getTitle(), entry.getValue());
        }
    }
}
