package school.faang.westeroslibrary79640;

import lombok.*;

import java.util.Objects;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private int year;
}
