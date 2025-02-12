package BJS2_57238;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        String loc1 = librarySystem.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "A1");
        String loc2 = librarySystem.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "A2");
        String loc3 = librarySystem.addBook("1984", "George Orwell", 1949, "A3");
        String loc4 = librarySystem.addBook("The Catcher in the Rye", "J.D. Salinger", 1951, "A4");
        try {
            String loc5 = librarySystem.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "A2");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        librarySystem.printAllBooks();

        System.out.println("-----------------------------------------");
        String result1 = librarySystem.removeBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        try {
            String result2 = librarySystem.removeBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        librarySystem.printAllBooks();
        System.out.println("-----------------------------------------");
        librarySystem.findBook("To Kill a Mockingbird", "Harper Lee", 1960);
    }
}
