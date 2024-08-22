package ironthrone;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@RequiredArgsConstructor
public class User {
    @NonNull
    private final String name;
    private House house;
    private HouseRole role;

    public void joinHouse(@NonNull House house) {
        this.house = house;
        synchronized (house) {
            if (house.isAnyRoleAvailable()) {
                setRole(house);
            } else {
                try {
                    System.out.printf("Waiting for available role in house of %s...%n", house.getName());
                    while (!house.isAnyRoleAvailable()) {
                        house.wait();
                    }
                    setRole(house);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void setRole(@NonNull House house) {
        var roles = house.getAvailableRoles();
        role = roles.get(ThreadLocalRandom.current().nextInt(roles.size()));
        house.addRole(role);
        System.out.printf("%s joined house of %s as %s%n", name, house.getName(), role);
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole(role);
            System.out.printf("%s leave house of %s%n", name, house.getName());
        }
        role = null;
        house = null;
    }
}
