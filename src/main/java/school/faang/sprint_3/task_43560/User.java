package school.faang.sprint_3.task_43560;

import lombok.Data;

import java.util.Random;

@Data
public class User {
    private static final int SLEEP_TIME = 5000;

    private static final Object houseLock = new Object();
    private static final Random random = new Random();

    private final String name;
    private House house;
    private Role role;

    public User(String name) {
        this.name = name;
        this.house = null;
        this.role = null;
    }

    public void joinHouse(House house) {
        synchronized (houseLock) {
            if (house.getAvailableRoles().isEmpty()) {
                try {
                    System.out.println(name + " ожидает пока освободится роль");
                    houseLock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Поток был прерван во время ожидания.");
                }
            }
            Role role = house.getAvailableRoles().get(random.nextInt(house.getAvailableRoles().size()));
            house.addRole(role);
            this.house = house;
            this.role = role;
            System.out.println(name + " присоединился к дому " + house.getName() + ". Его роль - " + role);
        }

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван во время сна.");
        }

        leaveHouse();
    }

    public void leaveHouse() {
        synchronized (houseLock) {
            Role role = getRole();
            System.out.println(name + " покидает дом " + house.getName() + " и освобождает роль: " + role);
            house.removeRole(role);
            houseLock.notify();
        }
    }
}
