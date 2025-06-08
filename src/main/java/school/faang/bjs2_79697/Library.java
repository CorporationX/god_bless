package school.faang.bjs2_79697;

public class Library {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        try {
            library.addBook("title1", "author1", 2020, "стеллаж 1");
            library.addBook("title2", "author2", 2021, "стеллаж 2");
            library.addBook("title3", "author3", 2022, "стеллаж 3");

            System.out.println(library.removeBook("title2", "author2", 2021));

            System.out.println(library.findBook("title5", "author3", 2022));
        } catch (IllegalArgumentException e) {
            System.out.println("caught exception " + e);
        }
        library.printAllBooks();
    }
}
