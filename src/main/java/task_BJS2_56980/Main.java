package task_BJS2_56980;

public class Main {
    public static void main(String[] args) {
        Book russianBook = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967);
        Book frenchBook = new Book("Маленький принц", "Антуан де Сент-Экзюпери", 1943);
        Book americanBook = new Book("451 градус по Фаренгейту", "Рэй Брэдбери", 1967);

        LibrarySystem.addBook(russianBook.getTitle(),
                russianBook.getAuthor(),
                russianBook.getYear(),
                "на 3-ий ряд, 4-ую полку");

        LibrarySystem.addBook(frenchBook.getTitle(),
                frenchBook.getAuthor(),
                frenchBook.getYear(),
                "на 1-ий ряд, 10-ую полку");

        LibrarySystem.addBook(americanBook.getTitle(),
                americanBook.getAuthor(),
                americanBook.getYear(),
                "на 20-ий ряд, 1-ую полку");


        System.out.println(LibrarySystem.removeBook(
                frenchBook.getTitle(), frenchBook.getAuthor(), frenchBook.getYear()));

        System.out.println(LibrarySystem.removeBook(
                frenchBook.getTitle(), frenchBook.getAuthor(), frenchBook.getYear()));


        System.out.println(LibrarySystem.findBook(
                frenchBook.getTitle(), frenchBook.getAuthor(), frenchBook.getYear()));

        LibrarySystem.printAllBooks();


    }
}
