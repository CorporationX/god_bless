package faang.school.godbless.FourthSprint.bjs2_51333;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@ToString
public class Comment {
    private final String text;
    private final User author;
    private final LocalDateTime timestamp;
}
