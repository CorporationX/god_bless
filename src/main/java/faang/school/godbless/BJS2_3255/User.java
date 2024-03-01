package faang.school.godbless.BJS2_3255;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull
    private String name;
    private House house = null;
    private String role = null;

    public void joinHouse(House house) {
        house.addUser(this);

    }

    public void leaveHouse() {
        house.removeUser(this);
    }
}
