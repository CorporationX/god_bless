package school.faang.westeroslibrary;

public class App {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Добавление книг в библиотеку
        library.addBook("Война и мир", "Лев Толстой", 1869, "Полка 1");
        library.addBook("Преступление и наказание", "Фёдор Достоевский", 1866, "Полка 2");
        library.addBook("Мастер и Маргарита", "Михаил Булгаков", 1966, "Полка 3");

        // Нахождение книги
        library.findBook("Война и мир", "Лев Толстой", 1869);

        //Поиск несуществующей книги
        library.findBook("Денискины рассказы", "Лев Толстой", 1869);

        // Удаление книги
        library.removeBook("Преступление и наказание", "Фёдор Достоевский", 1866);

        // Нахождение удаленной книги
        library.findBook("Преступление и наказание", "Фёдор Достоевский", 1866);

        // Печать всех книг и их местонахождения
        library.printAllBooks();
    }
}
