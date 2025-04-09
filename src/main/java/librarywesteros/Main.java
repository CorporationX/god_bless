package librarywesteros;

public class Main {
    public static void main(String[] args) {
        LibertySystem liberty = new LibertySystem();

        liberty.addBook("Война и мир", "Толстой", 1896, "Ряд 2 полка 12");
        liberty.addBook("Буратино", "Толстой", 1915, "Ряд 17 полка 7");
        liberty.addBook("Мастер и маргарита", "Булгаков", 1940, "Ряд 23 полка 2");

        liberty.printAllBooks();

        liberty.findBook("Война и мир", "Толстой", 1896);
        liberty.findBook("Буратино", "Толстой", 1915);
        liberty.findBook("Мастер и маргарита", "Булгаков", 1940);

        liberty.removeBook("Война и мир", "Толстой", 1896);
        liberty.removeBook("Война и мир", "Толстой", 1896);

        liberty.printAllBooks();
    }
}