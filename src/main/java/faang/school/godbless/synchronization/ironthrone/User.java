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
        System.out.printf("User [%s] attempting to join house [%s] -- %s\n",
                name, house.getName(), Thread.currentThread().getName());

        Role selectedRole;
        synchronized (house) {
            System.out.printf("User [%s] is under synchronized to join house [%s] -- %s\n",
                    name, house.getName(), Thread.currentThread().getName());
            while (house.getFreeRoles().isEmpty()) {
                System.out.printf("User [%s]: no free roles at the house waiting notify -- %s\n",
                        name, Thread.currentThread().getName());
                house.wait();
            }
            System.out.printf("User [%s] overcame condition block -- %s\n",
                    name, Thread.currentThread().getName());
            // Пользователь выбирает роль по какой-то своей логике
            selectedRole = pickRandomSetElement(house.getFreeRoles());
            System.out.printf("House free roles: %s\n", house.getFreeRoles());
            house.takeRole(selectedRole);
            System.out.printf("User [%s] took role [%s] of house [%s] -- %s\n",
                    name, selectedRole, house.getName(), Thread.currentThread().getName());
        }
        System.out.printf("User [%s] overcame synchronized of joining house [%s] -- %s\n",
                name, house.getName(), Thread.currentThread().getName());
        this.house = house;
        this.role = selectedRole;
        System.out.printf("User [%s] set fields: House.name [%s], role [%s] -- %s\n",
                name, house.getName(), role, Thread.currentThread().getName());
    }

    public void leaveHouse() {
        System.out.printf("User [%s] attempting to leave house [%s] -- %s\n",
                name, house.getName(), Thread.currentThread().getName());
        synchronized (house) {
            System.out.printf("User [%s] is under synchronized to leave house [%s] -- %s\n",
                    name, house.getName(), Thread.currentThread().getName());
            house.releaseRole(role);
        }
        System.out.printf("User [%s] overcame synchronized of leaving house [%s] -- %s\n",
                name, house.getName(), Thread.currentThread().getName());
        this.house = null;
        this.role = null;
        System.out.printf("User [%s] set fields: House [%s], role [%s] -- %s\n",
                name, house, role, Thread.currentThread().getName());
    }

    private <E> E pickRandomSetElement(Set<E> set) {
        return set.stream()
                .skip(new Random().nextInt(set.size()))
                .findFirst().orElseThrow(RuntimeException::new);
    }
}
