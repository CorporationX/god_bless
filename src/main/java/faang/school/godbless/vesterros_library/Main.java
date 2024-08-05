package faang.school.godbless.vesterros_library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book bookPushkin = new Book("Евгений Онегин", "А.С. Пушкин", 1833);
        Book bookDostoevsky = new Book("Преступление и Наказание", "Ф.М. Достоевский", 1866);
        Book bookTolstoy = new Book("Война и Мир", "Л.М. Толстой", 1867);

        System.out.println("Library after adding Books:");
        library.addBookToLibrary(bookPushkin, "1 ряд 3 полка");
        library.addBookToLibrary(bookDostoevsky, "2 ряд 1 полка");
        library.addBookToLibrary(bookTolstoy, "3 ряд 2 полка");
        library.showAllBooksInLibrary();
        System.out.println();

        System.out.println("Library after removing War and Peace:");
        library.deleteBookFromLibrary("Война и Мир", "Л.М. Толстой", 1867);
        library.showAllBooksInLibrary();
        System.out.println();

        library.searchBookInLibrary("Преступление и Наказание", "Ф.М. Достоевский", 1866);
        library.searchBookInLibrary("Война и Мир", "Л.М. Толстой", 1867);
    }
}
