package faang.school.godbless.multithreading.matters_of_the_heart;

import java.util.List;

public record UserList(List<User> users) {

    public List<User> getOnlineUsers() {
        return users.stream().filter(User::isOnline).toList();
    }
}
