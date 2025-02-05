package school.faang.vesteros;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Book {
    @NonNull
    private final String title;
    @NonNull
    private final String author;
    private final int year;
}
