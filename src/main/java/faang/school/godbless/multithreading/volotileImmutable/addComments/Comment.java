package faang.school.godbless.multithreading.volotileImmutable.addComments;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Comment {
    private String textComment;
    private LocalDateTime dateTimeComment;
    private String author;
}
