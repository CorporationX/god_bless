package faang.school.godbless.sprint_3.multithreading.iron_throne;

import lombok.Getter;

import java.util.List;

@Getter
public class House {
    private final List<String> freeRolesList;
    private int freeRolesCount;

    public House(List<String> roles) {
        this.freeRolesList = roles;
        freeRolesCount = freeRolesList.size();
    }

    public String addRole(int index) {
        String role = freeRolesList.remove(index);
        freeRolesCount -= 1;
        return role;
    }

    public void removeRole(String role) {
        synchronized (this) {
            freeRolesList.add(role);
            freeRolesCount += 1;
            this.notifyAll();
        }
    }
}
