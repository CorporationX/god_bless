package school.faang.bjs273164;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class User {
    private final String name;
    private final House house;
    private Role assignedRole;

    public void joinHouse(House house) {
        assignedRole = house.assignRole(this);
    }

    public void leaveHouse(House house) {
        if (assignedRole != null) {
            house.releaseRole(assignedRole);
            assignedRole = null;
        }
    }
}