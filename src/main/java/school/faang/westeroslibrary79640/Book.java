package school.faang.westeroslibrary79640;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

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
