package school.faang.ironthron;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class User {
    private final String name;
    @Setter
    private String assignedRole;

    public void joinHouse(House house) {
        house.assignRole(this);
    }

    public void leaveHouse(House house) {
        house.releaseRole(this);
    }
}