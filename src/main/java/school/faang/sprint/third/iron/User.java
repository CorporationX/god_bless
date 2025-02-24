package school.faang.sprint.third.iron;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class User {
    @NonNull
    private final String name;
    private final Role assignedRole;

    public User(@NonNull String name, Role assignedRole) {
        this.name = name;
        this.assignedRole = assignedRole;
    }

    public void joinHouse(House house) {
        house.assignRole(assignedRole, this);
    }

    public void leaveHouse(House house) {
        house.releaseRole(assignedRole);
    }
}
