package faang.school.godbless.sprint_3.task_48924;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class House {
    private final String name;
    private List<Roles> roles;
    private int numberOfAvailableRoles;

    public void addRole() {
        numberOfAvailableRoles--;
    }

    public void removeRole() {
        numberOfAvailableRoles++;
    }
}
