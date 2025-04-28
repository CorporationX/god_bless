package school.faang.facebook;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime created = LocalDateTime.now();
}
