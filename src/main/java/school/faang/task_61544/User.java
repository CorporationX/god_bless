package school.faang.task_61544;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class User {
    @NonNull
    private final String name;
    @NonNull
    private final HouseRole selectedRole;
    private House house = null;

    public void joinHouse(@NonNull House house) {
        house.assignRole(this);
        this.setHouse(house);
    }

    public void leaveHouse() {
        if (house != null) {
            house.releaseRole(selectedRole);
            house = null;
        }
    }
}
