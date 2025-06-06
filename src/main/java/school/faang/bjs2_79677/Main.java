package school.faang.bjs2_79677;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Добавление книг
        library.addBook("Война и мир", "Лев Толстой", 1869, "Полка A1");
        library.addBook("Преступление и наказание", "Фёдор Достоевский", 1866, "Полка B2");
        library.addBook("Мастер и Маргарита", "Михаил Булгаков", 1967, "Полка C3");

        System.out.println();

        // Поиск книги
        library.findBook("Преступление и наказание", "Фёдор Достоевский", 1866);
        library.findBook("Анна Каренина", "Лев Толстой", 1877);

        System.out.println();

        // Печать всех книг
        library.printAllBooks();

        System.out.println();

        // Удаление книги
        library.removeBook("Мастер и Маргарита", "Михаил Булгаков", 1967);
        library.removeBook("Неизвестная книга", "Неизвестный автор", 2000);

        System.out.println();

        // Печать всех книг после удаления
        library.printAllBooks();
    }
}
