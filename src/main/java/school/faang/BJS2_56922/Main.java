package school.faang.BJS2_56922;

public class Main {
    public static void main(String[] args) {
        LibarySystem librarySystem = new LibarySystem();
        librarySystem.addBook("Подсознание может все", "Джон Кехо", 2020, "Второй этаж, полка 10");
        librarySystem.addBook("Сказать жизни Да!", "Виктор Франкл", 2023, "Первый этаж, полка 21");
        librarySystem.findBook("Сказать жизни Да!", "Виктор Франкл", 2023);
        librarySystem.findBook("Мастер и Маргарита", "Михаил Булгаков", 2010);
        librarySystem.removeBook("Сказать жизни Да!", "Виктор Франкл", 2023);
        librarySystem.printAllBooks();
    }
}
