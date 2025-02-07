package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private final HashMap<Book, String> bookLocation = new HashMap<>();

    /**
     *
     * метод addBook пытается добавить книгу, проверяет на null,а также проверяет на пустоту отдельные поля
     * заполняется массив field значениями полей из книги, местоположение полей в массиве(индекс поля)
     * соответствует местоположению параметрам в методе
     * если одно из полей пустое, то перебираем поля в массиве и получаем имя поля с помощью switch\case
     */

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);

        ArrayList<String> fields = new ArrayList<>();
        fields.add(book.getTitle());
        fields.add(book.getAuthor());
        fields.add(String.valueOf(book.getYear()));
        fields.add(location);

        if (book != null) {
            if (book.getAuthor().isEmpty() || book.getTitle().isEmpty() || location.isEmpty()) {
                for (String field : fields) {
                    if (field.isEmpty()) {
                        switch (fields.indexOf(field)) {
                            case 0:
                                System.out.println("Book Title cannot be empty ");
                                break;
                            case 1:
                                System.out.println("Book Author cannot be empty ");
                                break;
                            case 2:
                                System.out.println("Book Year cannot be empty ");
                                break;
                            case 3:
                                System.out.println("Book Location cannot be empty ");
                                break;

                            default:
                                throw new IllegalArgumentException();
                        }
                    }
                }
            } else {
                bookLocation.put(book, location);
                StringBuilder addedBook = new StringBuilder();
                addedBook.append("Added Book: ")
                        .append(book.getTitle()).append(", ")
                        .append(book.getAuthor()).append(", ")
                        .append(book.getYear()).append(", ")
                        .append(location).append("\n");
                System.out.println(addedBook);
            }
        }
    }

    /**
     *
     * метод removeBook проверяет содержится ли в Map книга , которую мы хотим удалить,
     * если содержится то удаляет
     */
    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        StringBuilder removedBook = new StringBuilder();
        try {
            if (bookLocation.containsKey(book)) {
                removedBook.append("Removed Book: ")
                        .append(book.getTitle() + ", ")
                        .append(book.getAuthor() + ", ")
                        .append(book.getYear() + ", ")
                        .append(bookLocation.get(book) + "\n");
                System.out.println(removedBook);

                bookLocation.remove(book);
            }
        } catch (NullPointerException e) {
            System.out.println("Book not found");
        }
    }

    /**
     *
     * findBook-поиск книг по ключу ( стандартный метод map.getOrDefault включает в себя проверку на null,
     * если значение по ключу есть ,то возвращает его,
     * если нету , то отправляет сообщение)
     *
     */
    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        StringBuilder foundBook = new StringBuilder();
        foundBook.append("Found Book: ").append("\n")
                .append(book.getTitle()).append(", ")
                .append(book.getAuthor()).append(", ")
                .append(book.getYear()).append(", ").append("\n");
        if (bookLocation.containsKey(book)) {
            foundBook.append("Location: ").append(bookLocation.get(book)).append("\n");
        } else {
            foundBook.append("Book not found");
        }
        System.out.println(foundBook);

    }

    /**
     * printAllBooks - выводит список всех книг с помощью цикла
     */
    public void printAllBooks() {
        StringBuilder allBooks = new StringBuilder();
        if (bookLocation.isEmpty()) {
            allBooks.append("No books found");
        } else {
            for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
                allBooks.append("| Book | : ")
                        .append(entry.getKey().getAuthor()).append(", ")
                        .append(entry.getKey().getTitle()).append(", ")
                        .append(entry.getKey().getYear()).append(", ")
                        .append(" | Location | : ")
                        .append(entry.getValue())
                        .append("\n");
            }
        }
        System.out.println(allBooks);
    }
}
