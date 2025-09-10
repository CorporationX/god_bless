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
    }

    private static LibrarySystem createTestLibrary() {
        LibrarySystem library = new LibrarySystem();

        // Добавляем книги русских классиков
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
        library.removeBook("Облако в штанах", "Владимир Маяковский", 1915);

        System.out.println("• Удаляем существующую книгу:");
        library.removeBook("Евгений Онегин", "Александр Пушкин", 1833);

        System.out.println("\nОБНОВЛЕННЫЙ СПИСОК ПОСЛЕ УДАЛЕНИЯ:");
        library.printAllBooks();
    }

    private static void searchAndPrint(LibrarySystem library, String title, String author, int year) {
        String location = library.findBook(title, author, year);
        Book book = new Book(title, author, year);
        String result = location != null ? location : "Не найдена";
        System.out.printf("• %s → Локация: %s%n", book, result);
    }
}