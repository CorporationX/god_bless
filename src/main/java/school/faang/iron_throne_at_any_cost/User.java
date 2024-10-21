package school.faang.iron_throne_at_any_cost;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class User {
    private final String name;
    private final House house;
    @Setter
    private Role role;

    public synchronized void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            while (house.getAvailableRoleCount() == 0) {
                log.info(name + " waiting until role in the house " + house.getName() + " becomes available.");
                house.wait();
            }
            Role assignedRole = house.getAvailableRoles().get(0);
            this.setRole(assignedRole);
            log.info(name + " from the house of " + house.getName() + " has chosen the role: " + role);
            house.getAvailableRoles().remove(role);
        }
    }

    public synchronized void leaveHouse() {
        synchronized (house) {
            log.info(name + " is leaving the house " + house.getName() + " and vacate the role of: " + this.role);
            house.getAvailableRoles().add(role);
            house.notifyAll();
        }
    }
}