package school.faang.bjs251233;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class Comment {

    private String text;
    private String author;
    private LocalDateTime timestamp;

}
