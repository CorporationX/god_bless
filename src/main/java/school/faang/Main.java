package school.faang;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Vegetarian", "Han Kang", 2015);
        Book book2 = new Book("The Vegetarian", "Han Kang", 2015);

        System.out.println(book1.equals(book2));

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("The Vegetarian", "Han Kang", 2015, "1st shelf");
        librarySystem.addBook("The Vegetarian", "Han Kang", 2015, "2nd shelf");
        librarySystem.addBook("Morning and Evening", "Jon Fosse", 2015, "3rd shelf");
        librarySystem.addBook("A Girl’s Story", "Annie Ernaux", 2019, "4th shelf");
        librarySystem.addBook("Pilgrims Way", "Abdulrazak Gurnah", 1988, "1st shelf");
        librarySystem.addBook("Vita Nova", "Louise Glück", 1999, "5th shelf");

        System.out.println(librarySystem.findBook("The Vegetarian", "Han Kang", 2015));
        librarySystem.findBook("Vita Nova", "Louise Glück", 1999);
        librarySystem.printAllBooks();
        System.out.println();

        librarySystem.printAllBooks();
    }
}
