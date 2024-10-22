package school.faang.iron_throne_at_any_cost;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

@Getter
@Slf4j
public class House {
    private final String name;
    private final List<Role> availableRoles;
    private int currentAvailableRolesCount;

    public House(String name) {
        this.name = name;
        availableRoles = new LinkedList<>();
        this.currentAvailableRolesCount = 0;
    }

    public synchronized void assignRoleToUser(User user) throws InterruptedException {
        while (availableRoles.isEmpty()) {
            log.info(user.getName() + " waiting until a role in house " + this.name + " becomes available.");
            this.wait();
        }
        Role assignedRole = availableRoles.get(0);
        user.setRole(assignedRole);
        availableRoles.remove(assignedRole);
        currentAvailableRolesCount--;
        log.info(user.getName() + " from house " + this.name + " has been assigned the role " + user.getRole());
        log.info("Count of total available roles in the house of " + this.getName() + " is: " + currentAvailableRolesCount);
    }

    public synchronized void removeRoleFromUser(User user) {
        log.info(user.getName() + " is leaving the house " + this.name + " and vacating the role: " + user.getRole());
        availableRoles.add(user.getRole());
        user.setRole(null);
        user.setHouse(null);
        log.info(user.getName() + " is in the house of " + user.getHouse() + " and his role is " + user.getRole());
        currentAvailableRolesCount++;
        log.info("Count of total available roles in the house of " + this.getName() + " is: " + currentAvailableRolesCount);
        this.notifyAll();
    }

    public void addRole(List<Role> roles) {
        availableRoles.addAll(roles);
        currentAvailableRolesCount += roles.size();
        log.info("Added " + roles.size() + " roles to the house " + this.name);
        log.info("Count of total available roles in the house of " + this.getName() + " is: " + currentAvailableRolesCount);
    }
}