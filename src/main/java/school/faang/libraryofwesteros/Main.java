package school.faang.libraryofwesteros;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        Book book1 = new Book("Head First Java", "B.Bates & K.Sierra",
                2005);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J.K.Rowling",
                2014);
        Book book3 = new Book("Harry Potter and the Methods of Rational Thinking", "E. Yudkovsky",
                2018);

        librarySystem.addBook(book1, "Стеллаж К, полка №4");
        librarySystem.addBook(book2, "Стеллаж Ф, полка №2");
        librarySystem.addBook(book3, "Стеллаж Х, полка №4");

        librarySystem.findBook(book2);

        librarySystem.removeBook(book1);

        librarySystem.printAllBooks();
    }
}