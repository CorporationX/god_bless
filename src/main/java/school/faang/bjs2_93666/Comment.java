package school.faang.bjs2_93666;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Comment {
    private String text;
    private String author;
    private LocalDate timestamp;
}
