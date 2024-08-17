package faang.school.godbless.dolbahlop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;
}
