package school.faang.task_48837;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class User {
    private final String name;

    private House house;
    private Role chosenRole;

    private final Object roleLock;

    public User(@NonNull String name, @NonNull House house) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
        this.house = house;
        this.chosenRole = null;

        this.roleLock = new Object();
    }

    public void joinHouse() {
        synchronized (house.getLock()) {
            while (house.getAvailableRoleCount() == 0
                    && !Thread.currentThread().isInterrupted()) {
                try {
                    log.info("{} ждет, пока освободится роль в доме.", name);
                    house.getLock().wait();
                } catch (InterruptedException e) {
                    log.error("Thread {} was interrupted", Thread.currentThread().getName(), e);
                    Thread.currentThread().interrupt();
                }
            }
            if (!Thread.currentThread().isInterrupted()) {
                Optional<Role> role = house.addRole();
                role.ifPresentOrElse(this::chooseRole,
                        () -> log.warn("{} не удалось присоединиться к дому", name));
            }
        }
    }

    public void leaveHouse() {
        synchronized (house.getLock()) {
            if (chosenRole != null) {
                house.removeRole(chosenRole);
                log.info("{} покидает дом и освобождает роль: {}", name, chosenRole);
                removeRole();
                house.getLock().notifyAll();
            } else {
                log.warn("{} еще не присоединился к дому и не выбрал роль", name);
            }
        }

    }

    private void chooseRole(@NonNull Role role) {
        synchronized (roleLock) {
            this.chosenRole = role;
            log.info("{} выбирает роль: {}", name, role);
        }
    }

    private void removeRole() {
        synchronized (roleLock) {
            this.chosenRole = null;
        }
    }

}
