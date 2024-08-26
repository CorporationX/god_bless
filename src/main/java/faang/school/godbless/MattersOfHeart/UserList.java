package faang.school.godbless.MattersOfHeart;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class UserList {
    @Getter
    List<User> users = new ArrayList<>();

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
