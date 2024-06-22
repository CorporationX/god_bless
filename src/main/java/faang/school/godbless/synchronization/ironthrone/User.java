package faang.school.godbless.synchronization.ironthrone;

import lombok.NonNull;

import java.util.Random;
import java.util.Set;

public class User {
    private final String name;
    private House house;
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(@NonNull House house) throws InterruptedException {
        Role selectedRole;
        synchronized (house) {
            while (house.getFreeRoles().isEmpty()) {
                house.wait();
            }
            // Пользователь выбирает роль по какой-то своей логике
            selectedRole = pickRandomSetElement(house.getFreeRoles());
            house.takeRole(selectedRole);
        }
        this.house = house;
        this.role = selectedRole;
    }

    public void leaveHouse() {
        synchronized (house) {
            house.releaseRole(role);
        }
        this.house = null;
        this.role = null;
    }

    private <E> E pickRandomSetElement(Set<E> set) {
        return set.stream()
                .skip(new Random().nextInt(set.size()))
                .findFirst().orElseThrow(RuntimeException::new);
    }
}
