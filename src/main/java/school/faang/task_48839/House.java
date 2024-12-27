package school.faang.task_48839;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class House {
    private String name;
    private int countAvaliableRoles;
    private List<String> roles = new ArrayList<>();

    public void addRole() {
        countAvaliableRoles--;
    }

    public void removeRole() {
        countAvaliableRoles++;
    }
}
