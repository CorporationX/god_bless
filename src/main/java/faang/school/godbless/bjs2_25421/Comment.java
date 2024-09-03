package faang.school.godbless.bjs2_25421;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Comment {
    private int id;
    private String text;
    private LocalDateTime dateTime;
    private String author;
}
