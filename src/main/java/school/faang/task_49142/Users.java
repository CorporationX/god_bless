package school.faang.task_49142;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@Slf4j
public class Users {
    private final Set<User> users;

    public Users() {
        this.users = Collections.synchronizedSet(new HashSet<>());
    }

    public synchronized void addUser(@NonNull User user) {
        if (users.add(user)) {
            log.info("{} добавлен в список.", user);
        } else {
            log.warn("{} не удалось добавить в список.", user);
        }
    }

    public synchronized void removeUser(@NonNull User user) {
        if (users.remove(user)) {
            log.info("{} удалён из списка.", user);
        } else {
            log.warn("{} не удалось удалить из списка.", user);
        }
    }

    public synchronized User getAvailableUser(@NonNull User initiator) {
        return users.stream()
                .filter(user -> !user.equals(initiator)
                        && user.isAvailableForChat())
                .findAny().orElse(null);
    }

    public synchronized void forEach(Consumer<User> action) {
        users.forEach(action);
    }

}
