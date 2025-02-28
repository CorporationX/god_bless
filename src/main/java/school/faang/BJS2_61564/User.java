package school.faang.BJS2_61564;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {
    @Getter
    private final String name;
    private String assignedRole;

    public void joinHouse(House house) {
        assignedRole = house.assignRole(this);
        System.out.printf("%s получил роль %s!\n", name, assignedRole);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.printf("Ошибка при выполнении роли: %s", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        leaveHouse(house);
    }

    public void leaveHouse(House house) {
        System.out.printf("%s освободил роль %s!\n", name, assignedRole);
        house.releaseRole(assignedRole);
        assignedRole = null;
    }
}
