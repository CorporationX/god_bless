package school.faang;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Каласы пад сярпом тваім","Караткевіч",2005);
        Book book2 = new Book("Каласы пад сярпом тваім","Караткевіч",2005);
        Book book3 = new Book("Жалейка","Купала",1908);
        Book book4 = new Book("Спадчына","Купала",1922);

        System.out.println(book1.equals(book2));

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook(book1,"1st shelf");
        librarySystem.addBook(book2,"2nd shelf");
        librarySystem.addBook(book3,"3rd shelf");
        librarySystem.addBook(book4,"4th shelf");
        librarySystem.addBook("Новая зямля","Колас",1923,"1st shelf");
        librarySystem.addBook("Бывший сын","Филипенко",2014,"5th shelf");

        librarySystem.findBook(book1);
        librarySystem.findBook("Бывший сын","Филипенко",2014);
        librarySystem.printAllBooks();
        System.out.println();
        librarySystem.removeBook(book1);

        librarySystem.printAllBooks();
    }
}
