package faang.school.godbless.library;

import lombok.*;

@Getter
@EqualsAndHashCode(of = {"title", "author", "year"})
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;
}
