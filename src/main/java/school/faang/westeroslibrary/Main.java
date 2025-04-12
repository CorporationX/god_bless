package school.faang.westeroslibrary;

public class Main {
    public static void main(String[] args) {
        LibrarySystem lib = new LibrarySystem();

        lib.addBook("Олимпиада 1984", "Джордж Оруэлл", 1949, "A1");
        lib.addBook("Мастер и Маргарита", "Михаил Булгаков", 1966, "B3");
        lib.addBook("Преступление и наказание", "Федор Достоевский", 1866, "C2");

        System.out.println("\nПоиск книги: Олимпиада 1984, Джордж Оруэлл, 1949");
        System.out.println("Книга найдена на полке: " + lib.findBook("Олимпиада 1984", "Джордж Оруэлл", 1949));

        lib.removeBook("Олимпиада 1984", "Джордж Оруэлл", 1949);
        lib.printAllBooks();
    }
}