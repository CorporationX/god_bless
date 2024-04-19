package faang.school.godbless.synchronization.task_6.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
public class House {
    @Getter
    private final String name;
    private final List<Role> availableRoles;
    private int availableRolesNumber;

    public House(String name) {
        this.name = name;
        availableRoles = new ArrayList<>();
        availableRoles.add(Role.COIN_MASTER);
        availableRoles.add(Role.KNIGHT);
        availableRoles.add(Role.LORD);
        availableRoles.add(Role.HEALER);
        availableRoles.add(Role.MAGE);
    }

    public synchronized Role assignRole() {
        if (availableRolesNumber == 0) {
            try {
                this.wait(3000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
        Optional<Role> assignedRole = availableRoles.stream().findFirst();
        if (assignedRole.isEmpty()) {
            throw new NoSuchElementException("roles not found");
        } else {
            availableRoles.remove(assignedRole.get());
            availableRolesNumber = availableRoles.size();
        }
        return assignedRole.get();
    }

    public synchronized void makeRoleVacant(Role role) {
        availableRoles.add(role);
        availableRolesNumber = availableRoles.size();
        this.notifyAll();
    }
}
