package school.faang;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Vegetarian","Han Kang",2015);
        Book book2 = new Book("The Vegetarian","Han Kang",2015);
        Book book3 = new Book("Morning and Evening","Jon Fosse",2015);
        Book book4 = new Book("A Girl’s Story","Annie Ernaux",2019);

        System.out.println(book1.equals(book2));

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook(book1,"1st shelf");
        librarySystem.addBook(book2,"2nd shelf");
        librarySystem.addBook(book3,"3rd shelf");
        librarySystem.addBook(book4,"4th shelf");
        librarySystem.addBook("Pilgrims Way","Abdulrazak Gurnah",1988,"1st shelf");
        librarySystem.addBook("Vita Nova","Louise Glück",1999,"5th shelf");

        librarySystem.findBook(book1);
        librarySystem.findBook("Vita Nova","Louise Glück",1999);
        librarySystem.printAllBooks();
        System.out.println();
        librarySystem.removeBook(book1);

        librarySystem.printAllBooks();
    }
}
