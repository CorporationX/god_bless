package school.faang.module1.bjs2_83020;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp;
}