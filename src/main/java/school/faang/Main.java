package school.faang;

public class Main {
    public static void main(String[] args) {

        Book book = new Book();
        book.addBook("Sunny night", "Pol Brosnan", 1990, "Comedy");
        book.addBook("Very cold night", "Pol Brosnan", 1990, "Comedy");
        book.addBook("Summary", "Pol Brosnan", 1990, "Comedy");
        book.addBook("Little night", "Pol Brosnan", 1990, "Comedy");
        book.addBook("Funny night", "Pol Brosnan", 1990, "Comedy");

        book.findBook("Summary", "Pol Brosnan", 1990);
    }
}
