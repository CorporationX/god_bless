package school.faang.sprint_3.task_48859;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

import java.util.Queue;
import java.util.Random;

@Getter
public class House {
    @Getter(AccessLevel.NONE)
    private final Queue<Role> availableRoles;
    private final Random random = new Random();
    private int availableCountRoles;

    public House(@NonNull Queue<Role> availableRoles) {
        this.availableRoles = availableRoles;
        this.availableCountRoles = availableRoles.size();
    }

    public Role addPlayer() {
        if (availableCountRoles == 0) {
            throw new RuntimeException("House is full");
        }
        availableCountRoles--;
        return availableRoles.remove();
    }

    public void removePlayer(@NonNull Role role) {
        availableCountRoles++;
        availableRoles.add(role);
    }
}
