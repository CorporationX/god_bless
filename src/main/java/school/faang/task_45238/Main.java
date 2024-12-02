package school.faang.task_45238;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Война и мир", "Лев Толстой", 1867, "Полка 3");
        librarySystem.addBook("Гамлет", "Уильям Шекспир", 1623, "Полка 5");
        librarySystem.addBook("Сто лет одиночества", "Габриэль Гарсиа Маркес", 1967, "Полка 11");
        librarySystem.addBook("Дон Кихот", "Мигель де Сервантес", 1605, "Полка 8");

        librarySystem.printAllBooks();
        printDivider();

        librarySystem.findBook("Сто лет одиночеста", "Габриэль Гарсиа Маркес", 1967);
        printDivider();

        librarySystem.addBook("Война", "Толстой", 1832, "Полка 32");
        librarySystem.printAllBooks();
        printDivider();

        librarySystem.removeBook("Война", "Толстой", 1832);
        librarySystem.printAllBooks();
    }

    public static void printDivider() {
        System.out.println();
        System.out.println("==========================");
        System.out.println();
    }
}
