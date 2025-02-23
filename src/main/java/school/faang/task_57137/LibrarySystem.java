package school.faang.task_57137;

import java.util.HashMap;

public class LibrarySystem {
    private static final HashMap<Book, String> bookLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        if (title == null || title.isEmpty() || author == null || author.isEmpty()
                || location == null || location.isEmpty()) {
            System.out.println("Пустое поле!");
            return;
        }
        Book newBook = new Book(title, author, year);
        bookLocation.put(newBook, location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (bookLocation.containsKey(bookToRemove)) {
            bookLocation.remove(bookToRemove);
            System.out.printf("\nКнига %s удалена!\n", title);
            return true;
        } else {
            System.out.println("\nКнига не найдена!");
            return false;
        }
    }

    public String findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);

        if (bookLocation.get(bookToFind) != null) {
            System.out.printf("\nНомер позиции выбранной книги: %s\n", bookLocation.get(bookToFind));
            return bookLocation.get(bookToFind);
        } else {
            System.out.println("\nНомер позиции выбранной книги не найден");
            return null;
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
