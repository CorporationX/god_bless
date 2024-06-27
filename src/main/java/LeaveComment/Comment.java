package LeaveComment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Comment {
    private String name;
    private String comment;
    private LocalDateTime dateTime;
}
