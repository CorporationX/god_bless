package faang.school.godbless.multithreading_synchronization.task_6;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private final String name;
    private final House house;
    private final Role role;

    public synchronized void joinHouse() {
        if (house.roleIsIsOccupied(role)) {
            try {
                wait();

            } catch (InterruptedException e) {
                throw new RuntimeException(String.format("%s was interrupted while waiting for role", this.name));
            }
        }
        house.addRole(role);
        System.out.printf("%s was added to the house\n", this.name);
    }

    public synchronized void leaveHouse() {
        if (house.roleIsIsOccupied(role)) {
            house.removeRole(role);
            notifyAll();
            System.out.printf("%s was removed from the house\n", this.name);
        }
    }
}
