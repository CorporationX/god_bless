package school.faang.bjs2_68886;

public class Main {
    private static final LibrarySystem LIBRARY = new LibrarySystem();

    public static void main(String[] args) {
        LIBRARY.addBook("Задача трех тел", "Лю Цисинь", 2012, "Секция 3.1");
        LIBRARY.addBook("Мы", "Евгений Замянит", 1920, "Секция 2.1");
        LIBRARY.addBook("Хоббит", "Джон Толкин", 1937, "Секция 1.2");
        LIBRARY.addBook("Хоббит", "Джон Толкин", 1937, "Секция 1.2");
        LIBRARY.addBook("Хоббит", "Джон Толкин", 1937, "Секция 1.3");

        System.out.println(LIBRARY.findBook("Мы", "Евгений Замянит", 1920));
        LIBRARY.removeBook("Мы", "Евгений Замянит", 1920);
        System.out.println(LIBRARY.findBook("Мы", "Евгений Замянит", 1920));

        LIBRARY.printAllBooks();
    }
}
