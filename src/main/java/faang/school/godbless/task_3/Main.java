package faang.school.godbless.task_3;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();


        Book book1 = new Book("Poor Folk", "Dostoyevsky F.M.", 1846);
        Book book2 = new Book("The Idiot", "Dostoyevsky F.M.", 1869);
        Book book3 = new Book("Taras Bulba", "Gogol N.V.", 1835);
        Book book4 = new Book("Childhood", "Tolstoy L.N.", 1852);

        library.addBookInLibrary(book1, "rack-2");
        library.addBookInLibrary(book2, "rack-1");
        library.addBookInLibrary(book3, "rack-4");
        library.addBookInLibrary(book4, "rack-4");

        library.getAllBooksInLibrary();
        library.searchBookInLibrary(book2);

        library.removeBookInLibrary(book2);

        library.searchBookInLibrary(book2);

        library.getAllBooksInLibrary();
    }
}
