package faang.school.godbless.library;

public record Book(String title, String author, int year) {

    public Book {
        validate(title, author, year);
    }

    private void validate(String title, String author, int year) {
        if (title == null || title.trim().equals("") ||
                author == null || author.trim().equals("") ||
                year < 0){
            throw new IllegalArgumentException("Check input data for book");
        }
    }
}
