package Book;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Good", "albert", 2000);
        Book book2 = new Book("Bad", "alb", 1000);
        Book book3 = new Book("Beee", "Arlo", 1900);
        library.addbook(book1, "1");
        library.addbook(book2, "1");
        library.addbook(book3, "2");
        library.readMap(library.placebook);
        System.out.println("");

        library.removebook(book2);
        library.findBookPlace(book3);
        library.readMap(library.placebook);
    }
}




