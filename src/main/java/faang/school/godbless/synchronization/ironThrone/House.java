package faang.school.godbless.synchronization.ironThrone;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Getter
@Slf4j
public class House {
    private final String name;
    private final List<Role> availableRoles;
    private int availableRolesCount;

    public House(String name) {
        this.name = name;
        availableRoles = new ArrayList<>();

        availableRoles.add(Role.LORD);
        availableRoles.add(Role.KNIGHT);
        availableRoles.add(Role.MAGE);
        availableRoles.add(Role.BASTARD);

        availableRolesCount = availableRoles.size();
    }


    public synchronized Role addRole(Role value) {
        if (availableRolesCount == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                log.warn("Waiting for new available role was interrupted.", e);
            }
        }

        var joiningRole = availableRoles.stream().findFirst();

        if (joiningRole.isEmpty()) {
            throw new NoSuchElementException("Empty available roles list after notifying.");
        }

        availableRoles.remove(joiningRole.get());
        availableRolesCount = availableRoles.size();

        return joiningRole.get();
    }

    public synchronized void removeRole(Role role) {
        availableRoles.add(role);
        availableRolesCount = availableRoles.size();

        this.notify();
    }
}
