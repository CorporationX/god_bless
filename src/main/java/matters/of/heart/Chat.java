package matters.of.heart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chat {
    private User user1;
    private User user2;

    private final long id = System.nanoTime();
}
