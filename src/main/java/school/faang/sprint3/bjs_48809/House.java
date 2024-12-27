package school.faang.sprint3.bjs_48809;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class House {
    private final List<Role> availableRoles;

    public House(List<Role> listOfRoles) {
        this.availableRoles = new ArrayList<>(listOfRoles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House house)) return false;
        return Objects.equals(availableRoles, house.availableRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(availableRoles);
    }

    public synchronized int getFreeRolesCount() {
        return availableRoles.size();
    }

    public synchronized Role getRole() throws InterruptedException {
        if (!availableRoles.isEmpty()) {
            return availableRoles.remove(0);
        } else {
            throw new InterruptedException("Something wrong");
        }
    }

    public synchronized void returnRole(Role role) {
        availableRoles.add(role);
        log.info("Role {} now is in the available list", role);
    }
}
