package faang.school.godbless.BJS224176;

import lombok.Getter;

import java.util.List;

@Getter
public class House {
    private List<Role> roles;
    private int freeRoles;

    public House(List<Role> roles) {
        this.roles = roles;
        this.freeRoles = roles.size();
    }

    public void addRole() {
        synchronized (this) {
            this.freeRoles--;
        }
    }

    public void removeRole() {
        synchronized (this) {
            this.freeRoles++;
        }
    }
}
