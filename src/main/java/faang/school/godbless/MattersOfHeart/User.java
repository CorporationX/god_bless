package faang.school.godbless.MattersOfHeart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public class User {
    private int id;
    @EqualsAndHashCode.Exclude
    private String name;
    @Setter
    private Chat currentChat;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
