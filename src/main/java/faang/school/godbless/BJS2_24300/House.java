package faang.school.godbless.BJS2_24300;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.Set;

@AllArgsConstructor
public class House {
    private static Random random = new Random();
    private Set<Role> roles;

    public void joinHouse(User user, Role role) {
        if (roles.contains(role)) {
            role.takeRole();
            System.out.println(user.name()  + " joined the house");
            play(user, role);
        } else {
            System.out.println(role + " is not available");
        }
    }

    private void play(User user, Role role) {
        System.out.println(user.name() + " plays " + role);
        try {
            Thread.sleep(random.nextLong(1_000, 10_000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        leaveHouse(user, role);
    }

    private void leaveHouse(User user, Role role) {
        System.out.println(user.name() + " finished playing " + role);
        role.releaseRole();
    }
}