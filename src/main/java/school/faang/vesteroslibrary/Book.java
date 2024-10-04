package school.faang.vesteroslibrary;

public class Book {
    String title;
    String author;
    int year;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Название = " + title + ", Автор = " + author + ", Год = " + year + " ->";
    }

    @Override
    public int hashCode() {
        return 31 * title.hashCode() + author.hashCode() + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Book book = (Book) obj;
        return year == book.year && title.equals(book.title) && author.equals(book.author);
    }

}
