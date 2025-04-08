package school.faang.libraryofwesteros;

/**
 * Related to JIRA ticket: BJS2-68651
 */
public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр системы библиотеки
        LibrarySystem library = new LibrarySystem();

        System.out.println("==== Добавление книг ====");
        library.addBook("The Winds of Winter", "George R. R. Martin", 2020, "Shelf 1A");
        library.addBook("A Game of Thrones", "George R. R. Martin", 1996, "Shelf 2B");
        library.addBook("A Clash of Kings", "George R. R. Martin", 1998, "Shelf 2C");
        library.addBook("A Storm of Swords", "George R. R. Martin", 2000, "Shelf 3A");
        System.out.println();

        System.out.println("==== Вывод всех книг ====");
        library.printAllBooks();
        System.out.println();

        System.out.println("==== Поиск книги 'A Game of Thrones' ====");
        // Метод findBook выводит информацию о книге или сообщение, если книга не найдена.
        library.findBook("A Game of Thrones", "George R. R. Martin", 1996);
        System.out.println();

        System.out.println("==== Удаление книги 'A Game of Thrones' ====");
        library.removeBook("A Game of Thrones", "George R. R. Martin", 1996);
        System.out.println("После удаления книги:");
        library.printAllBooks();
        System.out.println();

        System.out.println("==== Поиск удаленной книги 'A Game of Thrones' ====");
        library.findBook("A Game of Thrones", "George R. R. Martin", 1996);
        System.out.println();
    }
}
