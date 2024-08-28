package faang.school.godbless.mattersOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

//логика чата : чат создается только тогда, когда 2 юзера готовы чатиться,
//поэтому чат может быть либо полностью заполненным, либо пустым
@Setter
@EqualsAndHashCode
@Getter
public class Chat {
    private Set<User> users;

    public Chat(User user1, User user2) {
        users = new HashSet<>(Set.of(user1, user2));
    }

    public boolean containsUser(User user) {
        return users.contains(user);
    }

    public void deleteChat() {
        users.clear();
    }
}
