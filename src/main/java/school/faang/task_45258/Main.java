package school.faang.task_45258;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Властелин колец", "Джон Р. Р. Толкин", 1900, "слева от той полки:)");
        librarySystem.addBook("Гордость и предубеждение", "Джейн Остин", 1813, "справа от той полки:)");
        librarySystem.addBook("Тёмные начала", "Филип Пулман", 1995, "внизу от той полки:)");
        librarySystem.addBook("Автостопом по галактике", "Дуглас Адамс", 1979, "ваще хз:)");
        librarySystem.addBook("Гарри Поттер и Кубок огня", "Джоан Роулинг", 2000, "на подоконике вроде:)");

        librarySystem.findBook("Властелин колец", "Джон Р. Р. Толкин", 1900);

        librarySystem.removeBook("Гарри Поттер и Кубок огня", "Джоан Роулинг", 2000);
        librarySystem.printAllBooks();


    }
}
