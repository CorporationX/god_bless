package school.faang.task57219.library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> BOOK_INFO = new HashMap<>();
    private static final String NO_BOOK_TITLE_MESSAGE;
    private static final String NO_BOOK_AUTHOR_MESSAGE;
    private static final String NO_BOOK_LOCATION_MESSAGE;
    private static final String ADD_BOOK_MESSAGE;
    private static final String REMOVE_BOOK_MESSAGE;
    private static final String FIND_BOOK_MESSAGE;
    private static final String PRING_ALL_BOOK_MESSAGE;
    private static final String ERROR_VALIDATION;

    static {
        NO_BOOK_TITLE_MESSAGE = "не заполнен title ";
        NO_BOOK_AUTHOR_MESSAGE = "не заполнен author ";
        NO_BOOK_LOCATION_MESSAGE = "не заполнен location ";
        ADD_BOOK_MESSAGE = "Книга \"%s\" добавлена в библиотеку, результат ";
        REMOVE_BOOK_MESSAGE = "Книга \"%s\" удалена, результат ";
        FIND_BOOK_MESSAGE = "Книга \"%s\" не найдена, результат ";
        PRING_ALL_BOOK_MESSAGE = "Книга \"%s\" автора %s %d года находится: %s\n";
        ERROR_VALIDATION = "Ошибка при валидации книги: %s, результат ";
    }

    public boolean addBook(String title, String author, int year, String location) {
        System.out.println("Добавление книги:");
        if (!checkValid(title, author, location)) {
            return false;
        }
        BOOK_INFO.put(new Book(title, author, year), location);
        System.out.printf(ADD_BOOK_MESSAGE, title);
        return true;
    }

    public boolean removeBook(String title, String author, int year) {
        System.out.println("Удаление книги:");
        if (!checkValid(title, author)) {
            return false;
        }
        BOOK_INFO.remove(new Book(title, author, year));
        System.out.printf(REMOVE_BOOK_MESSAGE, title);
        return true;
    }

    public boolean findBook(String title, String author, int year) {
        System.out.println("Поиск книги:");
        if (!checkValid(title, author)) {
            return false;
        }
        if (BOOK_INFO.get(new Book(title, author, year)) != null) {
            System.out.print(BOOK_INFO.get(new Book(title, author, year)) + ", результат ");
            return true;
        } else {
            System.out.printf(FIND_BOOK_MESSAGE, title);
            return false;
        }

    }

    public void printAllBooks() {
        System.out.println("Книги в библиотеке:");
        for (Map.Entry<Book, String> entry : BOOK_INFO.entrySet()) {
            System.out.printf(PRING_ALL_BOOK_MESSAGE, entry.getKey().getTitle(), entry.getKey().getAuthor(),
                    entry.getKey().getYear(), entry.getValue());
        }
    }

    private boolean checkValid(String title, String author) {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();
        if (title == null || title.isEmpty()) {
            errorMessage.append(NO_BOOK_TITLE_MESSAGE);
            isValid = false;
        }
        if (author == null || author.isEmpty()) {
            errorMessage.append(NO_BOOK_AUTHOR_MESSAGE);
            isValid = false;
        }
        if (!isValid) {
            System.out.printf(ERROR_VALIDATION, errorMessage);
            return false;
        }
        return true;
    }

    private boolean checkValid(String title, String author, String location) {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();
        if (title == null || title.isEmpty()) {
            errorMessage.append(NO_BOOK_TITLE_MESSAGE);
            isValid = false;
        }
        if (author == null || author.isEmpty()) {
            errorMessage.append(NO_BOOK_AUTHOR_MESSAGE);
            isValid = false;
        }
        if (location == null || location.isEmpty()) {
            errorMessage.append(NO_BOOK_LOCATION_MESSAGE);
            isValid = false;
        }
        if (!isValid) {
            System.out.printf(ERROR_VALIDATION, errorMessage);
            return false;
        }
        return true;
    }
}
