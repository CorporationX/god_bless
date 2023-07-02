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

    public void addRole() {
        synchronized (this) {
            freeRolesCount -= 1;
        }
    }

    public void removeRole() {
        synchronized (this) {
            freeRolesCount += 1;
            this.notify();
        }
    }
}
