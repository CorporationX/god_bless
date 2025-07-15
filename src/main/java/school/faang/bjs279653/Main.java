package school.faang.bjs279653;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook("Евгений Онегин", "Пушкин", 2025, "2 книжный шкаф, 3 ряд, 4 кника.");
        library.addBook("Война и мир", "Толстой", 2012, "3 книжный шкаф, 2 полка, 1 кника.");
        library.addBook("Няня", "Пушкин", 1945, "5 книжный шкаф, 1 полка, 6 кника.");

        library.findBook("Няня", "Пушкин", 1945);

        library.printAllBooks();

        library.removeBook("Няня", "Пушкин", 1945);
        System.out.println();
        library.printAllBooks();
    }
}
