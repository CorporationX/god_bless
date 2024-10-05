package westerosLibrary;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

}
