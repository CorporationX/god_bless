package school.faang.bjs2_81786;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Chat {
    private static final GeneratorId generatorChatId = new GeneratorId(0);

    private final long id;
    private User user1;
    private User user2;

    public Chat(User user1, User user2) {
        this.id = generatorChatId.nextId();
        this.user1 = user1;
        this.user2 = user2;
    }
}
