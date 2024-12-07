package school.faang.task_45332;

public class Main {

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addBook("title1", "author1", 1999, "shelf1");
        library.addBook("title2", "author2", 1998, "shelf2");
        library.addBook("title3", "author3", 1997, "shelf3");
        library.addBook("title4", "author4", 1996, "shelf4");
        library.addBook("title5", "author5", 1995, "shelf5");
        library.addBook("title5", "author5", 1995, "Shelf5");
        library.removeBook("title2", "author2", 1998);
        library.findBook("title6", "author6", 2000);
        library.printAllBooks();
    }
}