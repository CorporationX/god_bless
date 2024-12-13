package school.faang.bjs45307;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
