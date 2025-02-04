package toska27_BJS2_56980;

public class Main {
    public static void main(String[] args) {
        Book russianBook = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967);
        Book frenchBook = new Book("Маленький принц", "Антуан де Сент-Экзюпери", 1943);
        Book americanBook = new Book("451 градус по Фаренгейту", "Рэй Брэдбери", 1967);

        LibrarySystem.addBook(russianBook, "на 3-ий ряд, 4-ую полку");
        LibrarySystem.addBook(frenchBook, "на 1-ий ряд, 10-ую полку");
        LibrarySystem.addBook(americanBook, "на 20-ий ряд, 1-ую полку");

        System.out.println(LibrarySystem.removeBook(frenchBook));
        System.out.println(LibrarySystem.removeBook(frenchBook));

        System.out.println(LibrarySystem.findBook(frenchBook));

        LibrarySystem.printAllBooks();


    }
}
