package school.faang.bjs2_83012;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class Comment {
    private String text;
    private User author;
    private LocalTime timestamp;
}
