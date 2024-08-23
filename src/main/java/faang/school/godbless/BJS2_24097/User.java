package faang.school.godbless.BJS2_24097;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class User {
    @Getter
    private final String name;
    @Getter
    private String role;
    private final House house;

    public void joinHouse() {
        synchronized (house) {
            house.addRole(this);
        }
    }

        public void leaveHouse() {
            synchronized (house) {
                house.removeRole(this);
            }
        }
    }
