package school.faang.bjs273221;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
@Setter
public class User {
    private final String name;
    private Role assignedRole;

    public void joinHouse(House house) {
        house.assignRole(this);
    }

    public void leaveHouse(House house) {
        house.releaseRole(this);
    }
}
