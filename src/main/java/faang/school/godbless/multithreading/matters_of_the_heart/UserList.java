package faang.school.godbless.multithreading.matters_of_the_heart;

import java.util.List;
import java.util.Optional;

public record UserList(List<User> users) {

    public List<User> getOnlineUsers() {
        return users.stream().filter(User::isOnline).toList();
    }

    public void changeStatus(Optional<User> user) {
        if (user.isPresent()) {
            users.stream().filter(u -> u.hashCode() == user.hashCode()).forEach(u -> u.setCommunication(false));
        }
    }
}
