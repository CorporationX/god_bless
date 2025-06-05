package school.faang.the_library_of_westeros_bjs2_79622;

public class Main {
    public static void main(String[] args) {
        LibrarySystem ls = new LibrarySystem();
        ls.addBook("title1", "author1", 2000, "Sector D");
        ls.addBook("title2", "author2", 2001, "Sector B");
        ls.addBook("title3", "author3", 2002, "Sector D");
        ls.addBook("title4", "author4", 2003, "Sector C");

        ls.removeBook("title4", "author4", 2003);

        ls.findBook("title2", "author2", 2001);

        ls.printAllBooks();
    }
}
