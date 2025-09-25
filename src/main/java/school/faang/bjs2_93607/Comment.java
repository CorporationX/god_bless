package school.faang.bjs2_93607;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class Comment {
    private final String text;
    private final Author author;
    private final LocalDateTime timestamp;
}
