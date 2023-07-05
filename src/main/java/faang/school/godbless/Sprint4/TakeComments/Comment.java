package faang.school.godbless.Sprint4.TakeComments;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Comment {
    private String text;
    private LocalDate data;
    private String author;
}
