package school.faang.sprint3.task_48906;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
public class House {
    private static final int ROLE_RANDOMING_THRESHOLD = 5;

    private final Map<Role, Integer> availableRoles = new HashMap<>();

    public House() {
        Random random = new Random();
        List<Role> roles = new ArrayList<>(List.of(Role.values()));
        roles.stream()
                .forEach((role) -> availableRoles.put(role, random.nextInt(ROLE_RANDOMING_THRESHOLD)));
    }

    public void takeRole(@NonNull Role role) {
        availableRoles.merge(role, 1, (currentCount, decrement) -> currentCount - decrement);
    }

    public void freeRole(@NonNull Role role) {
        availableRoles.merge(role, 1, Integer::sum);
    }

    public void printRoles() {
        availableRoles.entrySet()
                .stream()
                .forEach(System.out::println);
    }

    public boolean isRoleAvailable(@NonNull Role role) {
        return availableRoles.get(role) > 0;
    }
}
