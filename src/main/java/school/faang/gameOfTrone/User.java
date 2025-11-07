package school.faang.gameOfTrone;

import lombok.RequiredArgsConstructor;

import javax.naming.Name;

@RequiredArgsConstructor
public class User {
    private final String name;
    private final String assignedRole;
    private House house = null;

    public void joinHouse(House house) {
        house.assignRole(name, assignedRole);
        this.house = house;
    }

    public void leaveHouse() {
        house.releaseRole(assignedRole);
    }
}
