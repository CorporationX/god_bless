package school.faang.westeroslibrary79640;


public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Старик и море", "Хемингуэй ", 1952, "1234");
        librarySystem.addBook("1984", "Джордж Оруэлл", 1949, "2334");
        librarySystem.addBook("Мастер и Маргарита", "Михаил Булгаков", 1967, "3243");
        librarySystem.addBook("Три товарища", "Эрих Мария Ремарк", 1936, "1234");
        librarySystem.addBook("Преступление и наказание", "Фёдор Достоевский", 1866, "2335");
        librarySystem.addBook("Гарри Поттер и философский камень", "Джоан Роулинг", 1997, "3456");
        librarySystem.addBook("Код да Винчи", "Дэн Браун", 2003, "2334");
        librarySystem.addBook("Война и мир", "Лев Толстой", 1869, "2345");

        librarySystem.printAllBooks();
        System.out.println(" ");
        librarySystem.findBook("Мастер и Маргарита", "Михаил Булгаков", 1967);
        System.out.println(" ");
        librarySystem.findBook("Морфий", "Михаил Булгаков", 1927);
        System.out.println(" ");
        librarySystem.removeBook("1984", "Джордж Оруэлл", 1949);
        System.out.println(" ");
        librarySystem.printAllBooks();
    }
}
