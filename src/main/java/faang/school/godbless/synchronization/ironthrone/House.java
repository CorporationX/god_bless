package faang.school.godbless.synchronization.ironthrone;

import lombok.Getter;

import java.util.EnumSet;
import java.util.Set;


public class House {
    @Getter
    private final String name;
    private final Set<Role> freeRoles;

    public House(String name) {
        this.name = name;
        this.freeRoles = EnumSet.allOf(Role.class);
    }

    public synchronized Set<Role> getFreeRoles() {
        return freeRoles;
    }

    public synchronized void takeRole(Role role) {
        freeRoles.remove(role);
    }

    public synchronized void releaseRole(Role role) {
        freeRoles.add(role);
        this.notifyAll();
    }
}
