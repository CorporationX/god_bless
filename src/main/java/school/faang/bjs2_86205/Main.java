package school.faang.bjs2_86205;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = createTestLibrary();

        System.out.println("=== ТЕСТИРОВАНИЕ БИБЛИОТЕЧНОЙ СИСТЕМЫ ===\n");

        System.out.println("1. ПЕРВОНАЧАЛЬНЫЙ СПИСОК КНИГ:");
        library.printAllBooks();
        System.out.println();

        System.out.println("2. ПОИСК КНИГ:");
        testBookSearch(library);

        System.out.println("\n3. ТЕСТ УДАЛЕНИЯ:");
        testBookRemoval(library);

        System.out.println("\n4. ТЕСТ ПРОВЕРКИ СУЩЕСТВОВАНИЯ:");
        testContainsBook(library);
    }

    private static LibrarySystem createTestLibrary() {
        LibrarySystem library = new LibrarySystem();

        library.addBook("Война и мир", "Лев Толстой", 1869, "Рус-1");
        library.addBook("Преступление и наказание", "Федор Достоевский", 1866, "Рус-2");
        library.addBook("Отцы и дети", "Иван Тургенев", 1862, "Рус-3");
        library.addBook("Евгений Онегин", "Александр Пушкин", 1833, "Рус-4");
        library.addBook("Мертвые души", "Николай Гоголь", 1842, "Рус-5");

        return library;
    }

    private static void testBookSearch(LibrarySystem library) {
        searchAndPrint(library, "Война и мир", "Лев Толстой", 1869);
        searchAndPrint(library, "Преступление и наказание", "Федор Достоевский", 1866);
        searchAndPrint(library, "Анна Каренина", "Лев Толстой", 1877); // Не найдена
        searchAndPrint(library, "Отцы и дети", "Иван Тургенев", 1862);
        searchAndPrint(library, "Ревизор", "Николай Гоголь", 1836); // Не найдена
    }

    private static void testBookRemoval(LibrarySystem library) {
        System.out.println("• Удаляем несуществующую книгу:");
        boolean removed1 = library.removeBook("Облако в штанах", "Владимир Маяковский", 1915);
        System.out.println("Результат: " + (removed1 ? "Удалена" : "Не найдена"));

        System.out.println("• Удаляем существующую книгу:");
        boolean removed2 = library.removeBook("Евгений Онегин", "Александр Пушкин", 1833);
        System.out.println("Результат: " + (removed2 ? "Удалена" : "Не найдена"));

        System.out.println("\nОБНОВЛЕННЫЙ СПИСОК ПОСЛЕ УДАЛЕНИЯ:");
        library.printAllBooks();
    }

    private static void testContainsBook(LibrarySystem library) {
        System.out.println("• Проверка существования книги:");
        boolean exists1 = library.containsBook("Война и мир", "Лев Толстой", 1869);
        boolean exists2 = library.containsBook("Анна Каренина", "Лев Толстой", 1877);
        System.out.println("'Война и мир' существует: " + exists1);
        System.out.println("'Анна Каренина' существует: " + exists2);
    }

    private static void searchAndPrint(LibrarySystem library, String title, String author, int year) {
        String result = library.findBook(title, author, year);
        System.out.printf("• %s (%d) → %s%n", title, year, result);
    }
}