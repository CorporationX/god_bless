package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private final HashMap<Book, String> bookLocation = new HashMap<>();
    Book book;

    /**
     *
     * метод addBook пытается добавить книгу , если не заполнены поля
     * , то выкидывет исключчение NullPointerException
     */

    public void addBook(String title, String author, int year, String location) {
        book = new Book(title, author, year);
        try {
            bookLocation.put(book, location);
            System.out.println("Book added: " + book);
        } catch (NullPointerException e) {
            System.out.println("Book is empty");
        }
    }

    /**
     *
     * метод removeBook проверяет содержится ли в Map книга , которую мы хотим удалить,
     * если содержится то удаляет
     */
    public void removeBook(String title, String author, int year) {
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        try {
            if (bookLocation.containsKey(book)) {
                System.out.println("Book deleted: " + book + bookLocation.get(book) + "\n");
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
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        System.out.println(bookLocation.getOrDefault(book, "This book does not exist"));

    }

    /**
     * printAllBooks - выводит список всех книг с помощью цикла
     */
    public void printAllBooks() {
        if (bookLocation.isEmpty()) {
            System.out.println("No books found");
        } else {
            for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
                System.out.println("| Book | : " + entry.getKey() + " | Location |: " + entry.getValue() + "\n");
            }
        }
    }
}
