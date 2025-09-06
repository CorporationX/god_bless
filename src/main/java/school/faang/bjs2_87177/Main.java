package school.faang.bjs2_87177;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        System.out.println("=== ТЕСТИРОВАНИЕ БИБЛИОТЕЧНОЙ СИСТЕМЫ ===\n");

        System.out.println("1. Добавление книг:");
        library.addBook("1984", "     George Orwell   ", 1949, "Полка 1, ряд 2");
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937, "Полка 2, ряд 1");
        library.addBook("Clean Code", "Robert C. Martin", 2008, "Полка 3, ряд 4");
        library.addBook("Effective Java     ", "  Joshua Bloch", 2018, "Полка 1, ряд 5");

        System.out.println("\n2. Попытка добавить дубликат:");
        library.addBook("1984", "George Orwell", 1949, "Полка 5, ряд 1");

        System.out.println("\n3. Текущее состояние библиотеки:");
        library.printAllBooks();

        System.out.println("\n4. Поиск книг:");
        library.findBook("The Hobbit    ", "J.R.R. Tolkien   ", 1937);
        library.findBook("Несуществующая книга    ", "   Неизвестный автор", 2023);

        System.out.println("\n5. Удаление книги:");
        library.removeBook("Clean Code", "Robert C. Martin", 2008);

        System.out.println("\n6. Состояние после удаления:");
        library.printAllBooks();

        System.out.println("\n8. Тестирование валидации:");
        try {
            library.addBook("", "Test Author", 2023, "Test Location");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        try {
            library.addBook("Test Title", "Test Author", -1, "Test Location");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }
    }
}
