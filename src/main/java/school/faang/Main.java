package school.faang;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> VesterosLibrary = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("Происхождение Джона Сноу", "Cэм Тарли", 313), "Зал 1 Полка 4");
        addBook(new Book("Происхождение Джона Сноу", "Cэм Тарли", 313), "Зал 1 Полка 4");
        addBook(new Book("История больших и малых домов", "Амори Лоркх", 31), "Зал 2 Полка 7");
        addBook(new Book("Легенды Долгой ночи", "Неизвестно", 12), "Зал 2 Полка 7");
        addBook(new Book("Правдивая история Танца драконов", "Неизвестно", 52), "Зал 6 Полка 1");

        removeBook(new Book("История больших и малых домов", "Амори Лоркх", 31));
        removeBook(new Book("Хоббит. Туда и Обратно", "Джон Рональд Руэл Толкиен", 1937));

        findBook(new Book("Правдивая история Танца драконов", "Неизвестно", 52));
        findBook(new Book("Звёздные войны. Эпизод V: Империя наносит ответный удар", "Джордж Лукас", 1980));

        showAllBooks();
    }

    public static void addBook(Book book, String bookLocation) {
        if (VesterosLibrary.containsKey(book)) {
            System.out.println("Книга " + book.getTitle() + " уже есть в библиотеке Вестероса");
        } else {
            VesterosLibrary.putIfAbsent(book, bookLocation);
            System.out.println(book + " добавлена. Местонахождение: " + bookLocation);
        }
    }

    public static void removeBook(Book book) {
        if (VesterosLibrary.containsKey(book)) {
            VesterosLibrary.remove(book);
            System.out.println(book + " Удалена из библиотеки Вестероса");
        } else {
            System.out.println(book + " Не найдена в библиотеке Вестероса");
        }
    }

    public static void findBook(Book book) {
        if (VesterosLibrary.containsKey(book)) {
            System.out.println(book + " найдена. Проследуйте в " + VesterosLibrary.get(book));
        } else {
            System.out.println(book + " не найдена в библиотеке Вестероса");
        }
    }

    public static void showAllBooks() {
        System.out.println("\nОтчет о всех книгах библиотеки Вестероса:");
        for (Map.Entry<Book, String> entry : VesterosLibrary.entrySet()) {
            System.out.println(entry.getKey() + " Находится на полке: " + entry.getValue());
        }
    }
}
