package school.faang.bjs2_79628;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Судьба человека", "М.А. Шолохов", 1956);
        Book book2 = new Book("Гранатовый Браслет", "А.И. Куприн", 1910);
        Book book3 = new Book("Ионыч", "А.П. Чехов", 1898);
        Book book4 = new Book("MyBook", "Me", 2025);

        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook(book1.getTitle(), book1.getAuthor(), book1.getYear(), "001");
        librarySystem.addBook(book2.getTitle(), book2.getAuthor(), book2.getYear(), "002");
        librarySystem.addBook(book3.getTitle(), book3.getAuthor(), book3.getYear(), "003");
        librarySystem.addBook(book4.getTitle(), book4.getAuthor(), book4.getYear(), "004");

        System.out.println(librarySystem.findBook("Судьба человека", "М.А. Шолохов", 1956));

        librarySystem.removeBook(book4.getTitle(), book4.getAuthor(), book4.getYear());
        librarySystem.removeBook("FDSAdsf", "dskjfdsj", 1221);
        librarySystem.printAllBooks();
    }
}
