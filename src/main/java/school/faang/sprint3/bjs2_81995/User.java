package school.faang.sprint3.bjs2_81995;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    @NonNull
    private String name;
    private String assignedRole;
    private House house;

    public void joinHouse(House house) {
        assignedRole = house.assignRole();
        this.house = house;
        System.out.printf("Присоединился к дому: %s, назначена роль: %s\n", house, assignedRole);
        spendTimeInHouse();
        leaveHouse();
    }

    public void leaveHouse() {
        synchronized (house) {
            if (assignedRole != null && !assignedRole.isEmpty()) {
                house.releaseRole(assignedRole);
                assignedRole = null;
            }
            if (house != null) {
                house = null;
            }
        }
    }

    public void spendTimeInHouse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
