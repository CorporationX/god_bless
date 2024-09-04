package leave.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Author {
    private final long id = System.nanoTime();
    private String name;
}
