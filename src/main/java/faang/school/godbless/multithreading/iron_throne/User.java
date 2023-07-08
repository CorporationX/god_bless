package faang.school.godbless.multithreading.iron_throne;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class User implements Runnable {
    private String name;
    private House house;
    private String role;

    public void joinHouse() {
        house.selectRole(role);
        System.out.printf("%s became %s in the %s house\n", name, role, house.getName());
    }

    public void leaveHouse() {
        house.releaseRole(role);
        System.out.printf("%s released role %s\n", name, role);
        house = null;
        role = null;
    }

    @Override
    public void run() {
        try {
            joinHouse();
            TimeUnit.SECONDS.sleep(3);
            leaveHouse();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
