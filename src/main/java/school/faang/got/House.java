package school.faang.got;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class House {

    private final List<String> availableRoles;
    private int availableRolesCount;
    @Getter
    @Setter
    private String name;

    public House(String name, List<String> availableRoles) {
        Objects.requireNonNull(availableRoles, "Role set cannot be null");
        this.name = name;
        this.availableRoles = new LinkedList<>(availableRoles);
        this.availableRolesCount = availableRoles.size();
    }

    public void addRole(User user) {
        Objects.requireNonNull(user, "User cannot be null");
        Random random = new Random();
        user.setRole(availableRoles.remove(random.nextInt(availableRolesCount)));
        availableRolesCount--;
    }

    public void removeRole(User user) {
        Objects.requireNonNull(user, "User cannot be null");
        availableRoles.add(user.getRole());
        availableRolesCount++;
    }

    public boolean areRolesAvailable() {
        return availableRolesCount > 0;
    }
}
