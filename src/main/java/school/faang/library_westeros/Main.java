package school.faang.library_westeros;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("1984", " Джордж Оруэлл", 1948, "A1");
        library.addBook("451 градус по Фаренгейту", "Рэй Дуглас Брэдбери", 1953, "C3");
        library.addBook("JAVA", "Кей Хорстманн", 2014, "B2");

        System.out.println();
        library.printAllBooks();

        System.out.println();
        library.findBook("1984", " Джордж Оруэлл", 1948);
        library.findBook("1983", " Джордж Оруэлл", 1948);

        System.out.println();
        library.removeBook("451 градус по Фаренгейту", "Рэй Дуглас Брэдбери", 1953);
        library.removeBook("451 градус по Фаренгейту", "Рэй Брэдбери", 1953);

        System.out.println();
        library.printAllBooks();
    }
}
