package school.faang.sprint_3.task_48988;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
public class House {
    private final List<Roles> availableRoles;
    private int currentNumberOfAvailableRoles;

    public House(List<Roles> roles) {
        this.availableRoles = roles;
        currentNumberOfAvailableRoles = roles.size();
    }

    public Roles addRole() {
        if (currentNumberOfAvailableRoles == 0) {
            throw new IllegalArgumentException("No roles available!");
        }
        currentNumberOfAvailableRoles--;
        return availableRoles.get(currentNumberOfAvailableRoles - 1);
    }

    public void removeRole() {
        currentNumberOfAvailableRoles++;
        notifyAll();
    }
}
