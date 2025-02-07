package school.faang.sprint.first.vesterosslibrary.model;

import lombok.NonNull;

import java.util.HashMap;

public class LibrarySystem {
    private final HashMap<Book, String> bookLocationInLibrary = new HashMap<>();

    public void addBook(@NonNull String title, @NonNull String author, int year, @NonNull String location) {
        if (isInputDataInvalid(new Object[]{title, author, year, location})) {
            System.out.println("Проверьте вводные данные");
            return;
        }

        Book book = new Book(title, author, year);
        String existingLocation = bookLocationInLibrary.putIfAbsent(book, location);
        if (existingLocation != null) {
            System.out.println("Книга уже располагается в разделе: " + existingLocation);
        }
    }

    public void removeBook(@NonNull String title, @NonNull String author, int year) {
        if (isInputDataInvalid(new Object[]{title, author, year})) {
            System.out.println("Проверьте вводные данные");
            return;
        }

        Book book = new Book(title, author, year);
        String existingLocation = bookLocationInLibrary.remove(book);
        if (existingLocation == null) {
            System.out.println("Такой книги нет");
        }
    }

    public void findBook(@NonNull String title, @NonNull String author, int year) {
        if (isInputDataInvalid(new Object[]{title, author, year})) {
            System.out.println("Проверьте вводные данные");
            return;
        }

        String bookLocation = bookLocationInLibrary.get(new Book(title, author, year));
        if (bookLocation != null) {
            System.out.println("Книга располагается в разделе: " + bookLocation);
        } else {
            System.out.println("Книга не найдена");
        }
    }

    public void printAllBooks() {
        if (bookLocationInLibrary.isEmpty()) {
            System.out.println("Библиотека пуста");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (var book : bookLocationInLibrary.entrySet()) {
            stringBuilder
                    .append("Книга: ")
                    .append(book.getKey())
                    .append(" располагается в локации: ")
                    .append(book.getValue())
                    .append("\r\n");
        }

        System.out.println(stringBuilder);
    }

    private boolean isInputDataInvalid(Object[] objects) {
        boolean isInvalid = false;

        for (Object o : objects) {
            if (o instanceof String && ((String) o).isBlank()) {
                isInvalid = true;
            } else if (o instanceof Integer && (int) o < 0) {
                isInvalid = true;
            }
        }

        return isInvalid;
    }
}
