package school.faang.bjs2_86053;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class Book {

    private String title;
    private String author;
    private int year;
}
