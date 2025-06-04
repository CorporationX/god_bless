package school.faang.the_library_of_westeros_bjs2_79622;

public class Main {
    public static void main(String[] args) {
        LibrarySystem ls1 = new LibrarySystem();
        ls1.addBook("title1", "author1", 2000, "Sector D");
        ls1.addBook("title2", "author2", 2001, "Sector B");
        ls1.addBook("title3", "author3", 2002, "Sector D");
        ls1.addBook("title4", "author4", 2003, "Sector C");

        ls1.removeBook("title4", "author4", 2003);

        ls1.findBook("title2", "author2", 2001);

        ls1.printAllBooks();
    }
}
