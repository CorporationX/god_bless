package faang.school.godbless.tinder;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserList {
    private List<User> userList;

    public List<User> getOnlineUsers() {
        return userList.stream()
                .filter(User::isOnline)
                .toList();
    }
}
