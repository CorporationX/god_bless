package school.faang.sprint1.vesteros_library_57192;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Битва королей", "Серсея Л.", 452, "Стенд 14, полка 29");
        librarySystem.addBook("Танец с драконами", "Дейнерис Т.", 470, "Стенд 44, полка 12");
        librarySystem.addBook("Как закончить вообще все", "Джон С./Т.", 490, "Стенд 99, полка 99");
        librarySystem.addBook("Оказался там где надо", "Бран С.", 500, "Стенд 1, полка 1");
        librarySystem.addBook("Оказался там где надо", "Бран С.", 500, "Стенд 1, полка 1");
        librarySystem.findBook("Битва королей", "Серсея Л.", 452);
        librarySystem.findBook("Танец с драконами", "Дейнерис Т.", 470);
        librarySystem.removeBook("Битва королей", "Серсея Л.", 452);
        librarySystem.printAllBooks();
    }
}
