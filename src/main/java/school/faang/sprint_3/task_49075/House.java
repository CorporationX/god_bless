package school.faang.sprint_3.task_49075;

import lombok.Data;

import java.util.List;

@Data
public class House {
    private List<String> roles;
    private int availableRoles;

    public House(List<String> roles) {
        this.roles = roles;
        this.availableRoles = roles.size();
    }

    public synchronized String addRole() {
        if (availableRoles == 0) {
            System.out.println("Нет доступных ролей");
        }
        int currentRoleIndex = availableRoles;
        availableRoles--;
        return roles.get(currentRoleIndex - 1);
    }

    public synchronized void removeRole() {
        availableRoles++;
        notifyAll();
    }
}
