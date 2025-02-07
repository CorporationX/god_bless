package school.faang;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;


}
