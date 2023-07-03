package faang.school.godbless.multithreading.iron_throne;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class House {

    private List<String> roles;
    private long availableRolesCount;

    public void addRole() {
        availableRolesCount--;
    }

    public void removeRole() {
        availableRolesCount++;
        this.notifyAll();
    }
}
