package school.faang.task_48837;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record User(@NonNull String name, @NonNull House house, @NonNull Role role) {
    public User {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    public void joinHouse() {
        synchronized (house) {
            house.addRole(this);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole(this);
        }
    }

}
