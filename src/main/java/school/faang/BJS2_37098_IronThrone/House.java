package school.faang.BJS2_37098_IronThrone;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class House {
    @Getter
    private String name;

    private List<String> availableRoles;

    public House(String name, List<String> availableRoles) {
        this.name = name;
        this.availableRoles = availableRoles;
    }

    public boolean isHasAvailableRoles() {
        return !availableRoles.isEmpty();
    }

    public String addRole(User user) {
        int randomRoleIndex = ThreadLocalRandom.current().nextInt(availableRoles.size());
        String randomAvailableRole = availableRoles.remove(randomRoleIndex);
        log.info("User {} has joined house {} as role {}", user.getName(), name, randomAvailableRole);
        return randomAvailableRole;
    }

    public void removeRole(User user) {
        if (user.getHouse() == this) {
            availableRoles.add(user.getRole());
            log.info("User {} has left the house {}", user.getName(), name);
        } else {
            log.warn("An attempt to remove a role from a user ({}) who does not belong to this house!", user.getName());
        }
    }
}
