package school.faang.bjs2_86096;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        try {
            library.addBook("Преступление и наказание", "Достоевский", 1866, "Shelf 2");
            library.addBook("Мастер и Маргарита", "Булгаков", 1967, "Shelf 3");
            library.addBook("Анна Каренина", "Толстой", 1877, "Shelf 1");
            library.addBook("Евгений Онегин", "Пушкин", 1833, "Shelf 4");
            library.addBook("1984", "Оруэлл", 1949, "Shelf 5");
            library.addBook("Гарри Поттер и философский камень", "Роулинг", 1997, "Shelf 6");
            library.addBook("2000", "Достоевский", 1869, "Shelf 2");
            library.addBook("Тихий Дон", "Шолохов", 1940, "Shelf 3");
            library.addBook("Три товарища", "Ремарк", 1936, "Shelf 7");
            library.addBook("111", "Маркес", 1967, "Shelf 8");
            library.removeBook("Три товарища", "Ремарк", 1936);
            library.removeBook("Война и мир", " ", 2024);
            library.findBook("Тихий Дон", "Шолохов", 1940);
            library.findBook(" ", "Шолохов", 1940);
            library.printAllBooks();
        } catch (IllegalArgumentException lib) {
            System.out.println(lib.getMessage());
        }
    }
}
