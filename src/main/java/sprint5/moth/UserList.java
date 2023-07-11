package sprint5.moth;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserList {
    private final List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .collect(Collectors.toList());
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
