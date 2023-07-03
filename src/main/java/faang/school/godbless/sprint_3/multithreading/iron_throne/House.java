package faang.school.godbless.sprint_3.multithreading.iron_throne;

import lombok.Getter;

import java.util.List;

@Getter
public class House {
    private List<String> freeRolesList;
    private int freeRolesCount;

    public House(List<String> roles) {
        this.freeRolesList = roles;
        freeRolesCount = freeRolesList.size();
    }

    public String addRole(int index) {
        synchronized (this) {
            String role = freeRolesList.get(index);
            freeRolesList.remove(index);
            freeRolesCount -= 1;
            return role;
        }
    }

    public void removeRole(String role) {
        synchronized (this) {
            freeRolesList.add(role);
            freeRolesCount += 1;
            this.notifyAll();
        }
    }
}
