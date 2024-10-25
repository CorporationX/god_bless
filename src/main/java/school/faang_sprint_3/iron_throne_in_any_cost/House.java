package school.faang_sprint_3.iron_throne_in_any_cost;

import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class House {
    private final String title;
    private final List<Role> roles;
    private int currentAvailableRoles;

    public House(String title, List<Role> roles) {
        this.title = title;
        this.roles = roles;
        this.currentAvailableRoles = roles.size();
    }

    public Optional<Role> addRole() {
        for (var role : roles) {
            if (role.isAvailable()) {
                currentAvailableRoles--;
                notifyAll();
                return Optional.of(role);
            }
        }
        return Optional.empty();
    }

    public void removeRole(Role role) {
        roles.get(roles.indexOf(role)).setAvailable(true);
        currentAvailableRoles++;
        notifyAll();
    }

    @Override
    public String toString() {
        return title + " current available roles: " + currentAvailableRoles;
    }
}
