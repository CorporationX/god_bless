package iron_throne_at_any_cost;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class House {
    private final String name;
    private final List<Role> roles;
    private int availableRolesCount = 5;

    public synchronized void addRole() {
        this.availableRolesCount--;
    }

    public void removeRole() {
        synchronized (this) {
            this.availableRolesCount++;
        }
        notifyAll();
    }
}
