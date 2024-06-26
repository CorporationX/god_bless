package faang.school.godbless.BJS2_12779;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
public class House {
    private final String name;
    private final List<String> roles;
    @Setter
    private int accessibleRolesCount = 3;
    private static final Random random = new Random();

    public House(String name, List<String> roles) {
        this.name = name;
        this.roles = roles;
    }

    synchronized public String addRole() {
        accessibleRolesCount--;
        notifyAll();
        return roles.get(random.nextInt(roles.size()));
    }

    synchronized public void removeRole() {
        accessibleRolesCount++;
        notifyAll();
    }
}
