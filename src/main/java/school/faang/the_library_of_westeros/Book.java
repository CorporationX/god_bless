package school.faang.the_library_of_westeros;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private int age;

    public Book(String title, String author, int age) {
        this.title = title;
        this.author = author;
        this.age = age;
    }
}
