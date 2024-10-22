package school.faang.BJS2_37098_IronThrone;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class House {
    private String name;
    private List<String> availableRoles;
    private int availableRolesAmount;

    public House(String name, List<String> availableRoles) {
        this.name = name;
        this.availableRoles = availableRoles;
        availableRolesAmount = availableRoles.size();
    }

    public boolean isHasAvailableRoles() {
        return availableRolesAmount > 0;
    }

    public void addRole(User user) {
        String randomAvailableRole = availableRoles.remove(ThreadLocalRandom.current().nextInt(availableRolesAmount));
        user.setRole(randomAvailableRole);
        user.setHouse(this);
        availableRolesAmount--;
        log.info("User {} has joined house {} as role {}", user.getName(), name, randomAvailableRole);
    }

    public void removeRole(User user) {
        if (user.getHouse() == this) {
            user.setHouse(null);
            availableRoles.add(user.getRole());
            user.setRole(null);
            availableRolesAmount++;
        } else {
            log.warn("An attempt to remove a role from a user ({}) who does not belong to this house!", user.getName());
        }
    }
}
