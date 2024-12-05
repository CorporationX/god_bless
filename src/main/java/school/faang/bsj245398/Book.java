package school.faang.bsj245398;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Book {
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private Integer year;
}
