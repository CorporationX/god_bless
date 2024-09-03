package faang.school.godbless.BJS2_25310;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Comment {
    private String text;
    private String author;
    private LocalDateTime date;
}
