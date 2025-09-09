package school.faang.bjs2_86104.library;

public record Book(String title, String author, int year) {
    public Book(String title, String author, int year) {
        BookValidator.validateBook(title, author, year);
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " -- " + author + " -- " + year;
    }
}
