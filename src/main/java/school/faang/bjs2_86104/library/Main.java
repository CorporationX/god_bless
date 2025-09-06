package school.faang.bjs2_86104.library;

public class Main {
    public static void main(String[] args) {
        Book firstBook = new Book("Портрет Дориана Грея", "Оскар Уайльд", 1890);
        Book secondBook = new Book("Книжный Вор", "Маркус Зусак", 2005);
        Book thirdBook = new Book("1984", "Джордж Оруэлл", 1949);
        Book fourthBook = new Book("Мёртвые души", "Николай Васильевич Гоголь", 1842);

        LibrarySystem.addBook(firstBook.title(), firstBook.author(), firstBook.year(), "1");
        LibrarySystem.addBook(secondBook.title(), secondBook.author(), secondBook.year(), "1");
        LibrarySystem.addBook(thirdBook.title(), thirdBook.author(), thirdBook.year(), "2");
        LibrarySystem.addBook(fourthBook.title(), fourthBook.author(), fourthBook.year(), "2");

        LibrarySystem.printAllBooks();
        System.out.println();

        System.out.print("Номер книжной полки произведения " + secondBook.title() + ": ");
        LibrarySystem.findBook("Книжный Вор", "Маркус Зусак", 2005);
        System.out.println();

        LibrarySystem.removeBook("Книжный Вор", "Маркус Зусак", 2005);

        LibrarySystem.printAllBooks();
    }
}
