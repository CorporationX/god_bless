package school.faang.bsj245398;


public class LibrarySystem {

    public void addBook(String title, String author, int year, String location) {
        Main.placeByBook.put(new Book(title, author, year), location);
    }

    public String removeBook(String title, String author, int year) {
        Book book = getBookByInfomation(title, author, year);

        if (book != null) {
            Main.placeByBook.remove(new Book(title, author, year));
            return "The book was deleted";
        }
        return "The book was not found";
    }

    public void findBook(String title, String author, int year) {
        Book book = getBookByInfomation(title, author, year);

        if (book != null) {
            printBookInformation(book, Main.placeByBook.get(book));
        } else {
            System.out.println("There is no such book in the library!");
        }
    }

    private Book getBookByInfomation(String title, String author, int year) {

        Book book = new Book(title, author, year);
        if (Main.placeByBook.containsKey(book)) {
            return book;
        }
        return null;
    }

    public void printAllBooks() {
        Main.placeByBook.forEach(this::printBookInformation);
    }

    private void printBookInformation(Book book, String location) {
        System.out.println(book + ",  location:" + location);
    }

}
