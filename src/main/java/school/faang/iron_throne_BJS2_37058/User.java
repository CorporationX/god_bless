package school.faang.iron_throne_BJS2_37058;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    public final static int WAIT_TIME = 7000;

    private String name;
    private House house;
    private String role;

    public void joinHouse() {
        System.out.printf("Player %s joined house\n", name);
        house.addRole(role);
        try {
            Thread.sleep(WAIT_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        leaveHouse();
    }

    public void leaveHouse() {
        System.out.printf("Player %s left house\n", name);
        house.removeRole(role);
    }
}
