package faang.school.godbless.BJS2_25322;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@ToString
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime dateTime;
}
