package school.faang.bjs248847;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    @Getter
    public final List<String> availableRoleList;
    public int availableRoleCount;

    public House(List<String> roles) {
        if (roles == null || roles.isEmpty()) {
            throw new IllegalArgumentException("Roles list cannot be null or empty.");
        }
        this.availableRoleList = new ArrayList<>(roles);
        this.availableRoleCount = availableRoleList.size();
        log.info("House initialized with roles: {}", roles);
    }

    public synchronized boolean isAvailableRoleList() {
        return availableRoleCount > 0;
    }

    public synchronized String addRole() {
        try {
            if (isAvailableRoleList()) {
                availableRoleCount--;
                String role = availableRoleList.remove(0);
                log.info("Role assigned: {}. Remaining roles: {}", role, availableRoleCount);
                return role;
            }
        } catch (Exception e) {
            log.warn("No roles available to assign: {}", e.getMessage());
        }
        return null;
    }

    public synchronized void removeRole(String role) {
        if (role == null || role.isEmpty()) {
            throw new IllegalArgumentException("Role to remove cannot be null or empty.");
        }
        availableRoleList.add(role);
        availableRoleCount++;
        log.info("Role released: {}. Available roles: {}", role, availableRoleCount);
        notifyAll();
    }
}
