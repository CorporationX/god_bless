package faang.school.godbless.module.first.hashmap.library;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;
}
