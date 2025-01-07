package school.faang.task_50751;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class TwitterAccount {
    private String username;
    private List<User> users = new ArrayList<>();

    public TwitterAccount(String username) {
        this.username = username;
    }

    public synchronized void addUserToAccount(User user) {
        users.add(user);
    }

    public synchronized void deleteUserFromAccount(User user) {
        users.remove(user);
    }
}
