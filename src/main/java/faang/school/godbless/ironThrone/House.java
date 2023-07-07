package faang.school.godbless.ironThrone;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class House {
    private List<String> availableRoles;

    public House() {
        this.availableRoles = new ArrayList<>();
    }

    public void addRole(String role) {
        availableRoles.add(role);
    }

    public void removeRole(String role) {
        availableRoles.remove(role);
    }

    public boolean hasAvailableRoles() {
        return !availableRoles.isEmpty();
    }

    public String getAvailableRole() {
        if (availableRoles.isEmpty()) {
            return null;
        }
        return availableRoles.get(0);
    }
}
