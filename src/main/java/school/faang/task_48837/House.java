package school.faang.task_48837;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class House {
    private final Set<Role> availableRoles;

    public House(@NonNull Set<Role> roles) {
        this.availableRoles = new HashSet<>(roles);
    }

    public void addRole(@NonNull User user) {
        boolean interrupted = false;
        while ((availableRoles.isEmpty()
                || !availableRoles.contains(user.role()))
                && !interrupted) {
            log.info("{} ждет, пока освободится роль в доме.", user.name());
            try {
                wait();
            } catch (InterruptedException e) {
                interrupted = true;
                log.error("Thread {} was interrupted", Thread.currentThread().getName(), e);
            }
        }
        if (availableRoles.remove(user.role()) && !interrupted) {
            log.info("{} выбирает роль: {}", user.name(), user.role());
        }
    }

    public void removeRole(@NonNull User user) {
        log.info("{} покидает дом и освобождает роль: {}", user.name(), user.role());
        availableRoles.add(user.role());
        notifyAll();
    }

}
