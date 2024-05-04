package faang.school.godbless.BJS2_6189;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Comment {
    private String text;
    private LocalDateTime createdAt;
    private String Author;
}
