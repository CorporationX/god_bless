package school.faang.sprint_1.task_45320;

public record Book(String title, String author, int year) {
    @Override
    public String toString() {
        return "Book{"
                + "title='" + title
                + '\''
                + ", author='" + author
                + '\''
                + ", year=" + year
                + '}';
    }
}
