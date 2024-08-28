package faang.school.godbless.MattersOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Slf4j
@ToString
public class Chat {
    private final Set<User> users = new HashSet<>();
    private final int topCapacityOfUsers;

    public void sendMessage(User user) {
        synchronized (users){
        log.info("From {} massage to users - {}", user, users.toArray());
        }
    }

    public boolean permissionByChatCapacity() {
        synchronized (users){
        return users.size() < topCapacityOfUsers;
        }
    }

    public void addUserToChat(User user) {
        users.add(user);
        user.addChat(this);
        log.info("user {} added                amount users = {}", user.getId(), users.size());
    }

    public void deleteUserFromChat(User user) {
        users.remove(user);
        user.removeChat(this);
        log.info("user {} leaved                amount users = {}", user.getId(), users.size());
    }

}
