package school.faang.task_48931;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class House {
    private List<Role> availableRoles;
    private int currentAvailableRoles;

    public House(List<Role> availableRoles) {
        this.availableRoles = availableRoles;
        this.currentAvailableRoles = availableRoles.size();
    }

    public synchronized Role addPlayer() {
        if (currentAvailableRoles == 0) {
            throw new IllegalStateException("Нет доступных ролей");
        }
        currentAvailableRoles--;
        return availableRoles.remove(0);
    }

    public synchronized void removePlayer(Role role) {
        currentAvailableRoles++;
        availableRoles.add(role);
        notifyAll();
    }
}
