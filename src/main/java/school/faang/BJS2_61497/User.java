package school.faang.BJS2_61497;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {
    private final String name;
    private String assignedRole;

    public void joinHouse(@NonNull House house) {
        assignedRole = house.assignRole();
        System.out.println(String.format("User %s took role %s", this.name, this.assignedRole));
    }

    public void leaveHouse(@NonNull House house) {
        house.releaseRole(assignedRole);
        System.out.println(String.format("User %s released role %s", this.name, this.assignedRole));
    }
}
