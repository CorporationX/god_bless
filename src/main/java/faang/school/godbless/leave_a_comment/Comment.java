package faang.school.godbless.leave_a_comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Comment {
    private String text;
    private String author;
    private String dateTime;
}
