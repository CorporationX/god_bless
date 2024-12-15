package school.faang.task_48814;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private final House house;

    public synchronized void joinHouse() throws InterruptedException {
        house.chooseRole(this);
        System.out.println(name + " chose role : " + house.getUsersPerRoles().get(this));
    }

    public synchronized void leaveHouse() {
        house.removeRole(this);
        System.out.println(name + " leaves the house! His role is available!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        };
        if (o == null || getClass() != o.getClass()) {
            return false;
        };
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
