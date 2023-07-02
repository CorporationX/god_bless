package faang.school.godbless.iron_throne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class House {
    private String name;
    private List<String> roles;
    private int availableRoles;

    public void addRole(){
        availableRoles++;
    }

    public void removeRole(){
        availableRoles--;
    }
}
