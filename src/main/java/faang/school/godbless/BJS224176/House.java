package faang.school.godbless.BJS224176;

import lombok.Getter;

import java.util.List;

@Getter
public class House {
    private List<Role> roles;
    private int freeRoles;
    private final Object lock = new Object();

    public House(List<Role> roles) {
        this.roles = roles;
        this.freeRoles = roles.size();
    }

    public void addRole() {
        synchronized (lock) {
            this.freeRoles--;
        }
    }

    public void removeRole() {
        synchronized (lock) {
            this.freeRoles++;
        }
    }
}
