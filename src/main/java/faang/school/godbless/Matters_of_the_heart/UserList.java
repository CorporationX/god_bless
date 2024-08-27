package faang.school.godbless.Matters_of_the_heart;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@NoArgsConstructor
public class UserList {
    private final List<User> users = new ArrayList<>();

    public synchronized void addUser(User user) {
        users.add(user);
        log.info("Добавлен пользователь: {}", user.getName());
    }

    public synchronized List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline).collect(Collectors.toList());
    }
}
