package school.faang.libraryw;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        try {
            librarySystem.addBook("1984", "Джордж Оруэлл", 1949, "A1");
            librarySystem.addBook("Война и мир", "Лев Толстой", 1869, "B2");
            librarySystem.addBook("Мастер и Маргарита", "Михаил Булгаков", 1967, "C4");
            librarySystem.addBook("Убить пересмешника", "Харпер Ли", 1960, "B5");
            librarySystem.addBook("Гарри Поттер и философский камень", "Дж.К. Роулинг", 1997, "C1");

            librarySystem.removeBook("Мастер и Маргарита", "Михаил Булгаков", 1967);
            librarySystem.findBook("1984", "Джордж Оруэлл", 1949);
            librarySystem.findBook("Мастер и Маргарита", "Михаил Булгаков", 1967);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        librarySystem.printAllBooks();
    }
}
