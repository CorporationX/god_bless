package faang.school.godbless.week1.GameOfThrones;


import java.util.Objects;
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year){
        this.title=title;
        this.author=author;
        this.year=year;
    }
    //Geters
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getYear(){
        return  year;
    }
    //compate books by title author, year
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }


    //hashcode to generat a hasg based on title author and year
    @Override
    public int hashCode(){
        return Objects.hash(title,author,year);
    }
    @Override
    public String toString(){
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
