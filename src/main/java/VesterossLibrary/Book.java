package VesterossLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;
}
