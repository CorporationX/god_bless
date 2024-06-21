package faang.school.godbless.iron_throne_at_any_cost;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private String name;
    private House house;
    private Role role;

    public void joinHouse() throws InterruptedException {
        synchronized (house) {
            if (house.getAvailableRoles().get(role) == 0) {
                house.wait();
            }
            addRole();
            System.out.printf("%s: %s joined the house with role %s\n", Thread.currentThread().getName(), name, role.name());
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            removeRole();
            house.notifyAll();
            System.out.printf("%s: %s leaved the house\n", Thread.currentThread().getName(), name);
        }
    }

    private void addRole() {
        house.getAvailableRoles().compute(role, (k, current) -> current - 1);
    }

    private void removeRole() {
        house.getAvailableRoles().compute(role, (k, current) -> current + 1);
    }
}
