package school.faang.sprint3.bjs_48809;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class House {
    private final List<String> availableRoles;
    private int freeRolesCount;

    public House(List<String> listOfRoles) {
        this.availableRoles = new ArrayList<>(listOfRoles);
        this.freeRolesCount = availableRoles.size();
    }

    public synchronized void getTheRole(String role) {
        if (availableRoles.contains(role)) {
            availableRoles.remove(role);
            freeRolesCount = availableRoles.size();
        }
    }

    public synchronized void releaseRole(String role) {
        availableRoles.add(role);
        freeRolesCount++;
        log.info("Role {} now is in the available list", role);
    }
}
