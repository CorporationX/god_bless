package school.faang.bjs2_86260_1_1_3_1_vesteros_library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    @Getter
    private String title;
    private String author;
    private Integer year;
}
