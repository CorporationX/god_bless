package school.faang.bjs2_86053;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("Кафе на краю земли", "Джон Стрелеки", 2002, "USA");
        library.addBook("Возвращение в кафе", "Джон Стрелеки", 2018, "USA");

        library.removeBook("Возвращение в кафе", "Джон Стрелеки", 2018);

        library.findBook("Кафе на краю земли", "Джон Стрелеки", 2002);

        library.printAllBooks();
    }
}
