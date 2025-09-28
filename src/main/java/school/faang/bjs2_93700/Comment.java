package school.faang.bjs2_93700;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Comment {
    private String text;
    private String author;
    private LocalDateTime timestamp;
}
