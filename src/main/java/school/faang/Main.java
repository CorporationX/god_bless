package school.faang;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        Book book2 = new Book("Sunny day", "Paul Anderson", 1978);
        Book book3 = new Book("Alan Wake", "J.R.R. Tolkien", 1954);
        Book book4 = new Book("One Republic", "J.R.R. Tolkien", 1954);
        Book book5 = new Book("Diary", "For me", 2025);

        library.addBook(book1, "A1");
        library.addBook(book2, "B3");
        library.addBook(book3, "A2");
        library.addBook(book4, "B4");
        library.addBook(book5, "B1");


        library.removeBook("Sunny day", "Paul Anderson", 1978);
        boolean isRemoved = library.removeBook("Diary", "For me", 2025);
        if (isRemoved) {
            System.out.println("Книга 'Diary' успешно удалена из библиотеки!");
        } else {
            System.out.println("Книга 'Diary' не найдена, удаление не выполнено.");
        }

        System.out.println(library.getBookLocation(book2));
        library.printAllBooks();
    }
}
