package school.faang.bjs45307;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
public class Book {
    private String title;
    private String author;
    private int year;
}
