package faang.school.godbless.synchronization.ironthrone;

import lombok.Getter;

import java.util.EnumSet;
import java.util.Set;

@Getter
public class House {
    private final String name;
    private Set<Role> freeRoles;

    public House(String name) {
        this.name = name;
        this.freeRoles = EnumSet.allOf(Role.class);
    }

    public void takeRole(Role role) {
        freeRoles.remove(role);
    }

    public void releaseRole(Role role) {
        freeRoles.add(role);
        this.notifyAll();
    }
}
