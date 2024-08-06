package faang.school.godbless.vesteros_lib;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;


@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
    @NonNull private String title;
    @NonNull private String author;
    @NonNull private int year;
}
