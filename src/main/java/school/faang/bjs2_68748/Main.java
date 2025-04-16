package school.faang.bjs2_68748;

/**
 * Задача "Библиотека Вестеросса"
 */
public class Main {
    public static void main(String[] args) {
        var fantasticLibrary = new LibrarySystem();

        fantasticLibrary.addBook("Спин", "Роберт Чарльз Уилсон", 2005, "Полка 1");
        fantasticLibrary.addBook("Война миров Z", "Макс Брукс", 2006, "Полка 2");
        fantasticLibrary.addBook("Ложная слепота", "Натан Кларк", 2006, "Полка 100500");

        fantasticLibrary.printAllBooks();

        System.out.println();
        fantasticLibrary.findBook("Марсианин", "Энди Вейер", 2011);
        fantasticLibrary.findBook("Спин", "Роберт Чарльз Уилсон", 2005);

        fantasticLibrary.removeBook("Спин", "Роберт Чарльз Уилсон", 2005);

        System.out.println();
        fantasticLibrary.printAllBooks();
    }
}
