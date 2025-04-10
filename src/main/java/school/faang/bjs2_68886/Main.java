package school.faang.bjs2_68886;

public class Main {
    private static final LibrarySystem library = new LibrarySystem();

    public static void main(String[] args) {
        library.addBook("Задача трех тел", "Лю Цисинь", 2012, "Секция 3.1");
        library.addBook("Мы", "Евгений Замянит", 1920, "Секция 2.1");
        library.addBook("Хоббит", "Джон Толкин", 1937, "Секция 1.2");
        library.addBook("Хоббит", "Джон Толкин", 1937, "Секция 1.2");
        library.addBook("Хоббит", "Джон Толкин", 1937, "Секция 1.3");

        printResult(library.findBook("Мы", "Евгений Замянит", 1920));
        library.removeBook("Мы", "Евгений Замянит", 1920);
        printResult(library.findBook("Мы", "Евгений Замянит", 1920));

        library.printAllBooks();
    }

    private static void printResult(boolean result) {
        if (result) {
            System.out.println("Книга найдена!");
        } else {
            System.out.println("Что то уже нет такой книги...");
        }
    }
}
