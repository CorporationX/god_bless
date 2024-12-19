package school.faang.task_48888;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class House {
    private final String houseName;
    private final List<UserRole> userRoles;
    private int possiblePosition;

    public House(String houseName, List<UserRole> userRoles) {
        this.houseName = houseName;
        this.userRoles = new ArrayList<>(userRoles);
        possiblePosition = userRoles.size();
    }

    public void addRole(UserRole role) {
        this.possiblePosition--;
        userRoles.remove(role);
    }

    public void removeRole(UserRole role) {
        possiblePosition++;
        userRoles.add(role);
    }
}
