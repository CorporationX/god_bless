package school.faang.task_48837;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    private final String name;
    private final House house;
    private Role chosenRole;

    public User(@NonNull String name, @NonNull House house) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
        this.house = house;
        this.chosenRole = null;
    }

    public void joinHouse() {
        synchronized (house) {
            boolean interrupted = false;
            while (house.getAvailableRoleCount() == 0 && !interrupted) {
                try {
                    log.info("{} ждет, пока освободится роль в доме.", name);
                    house.wait();
                } catch (InterruptedException e) {
                    interrupted = true;
                    log.error("Thread {} was interrupted", Thread.currentThread().getName(), e);
                }
            }
            Role role = house.addRole();
            chooseRole(role);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole(chosenRole);
            log.info("{} покидает дом и освобождает роль: {}", name, chosenRole);
            house.notifyAll();
        }
    }

    private void chooseRole(@NonNull Role role) {
        this.chosenRole = role;
        log.info("{} выбирает роль: {}", name, role);
    }

}
