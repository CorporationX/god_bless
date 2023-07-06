package faang.school.godbless.sprint5.commentary.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Comment {
    private String text;
    private LocalDate date;
    private String author;

}
