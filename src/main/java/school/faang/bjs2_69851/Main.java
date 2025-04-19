package school.faang.bjs2_69851;

public class Main {
    public static void main(String [] args) {
        var library = new LibrarySystem();

        library.addBook("Игра престолов", "Джордж Мартин", 1996, "Полка 1");
        library.addBook("Песнь льда и огня", "Джордж Мартин", 1996, "Полка 2");
        library.addBook("Буря мечей", "Джордж Мартин", 2000, "Полка 2");

        library.findBook("Игра престолов", "Джордж Мартин", 1996);
        library.findBook("Песнь льда и огня", "Джордж Мартин", 1996);
        library.findBook("Буря мечей", "Джордж Мартин", 2000);

        library.printAllBooks();

        library.removeBook("Игра престолов", "Джордж Мартин", 1996);
        library.printAllBooks();
    }
}