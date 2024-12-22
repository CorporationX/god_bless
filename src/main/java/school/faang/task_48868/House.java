package school.faang.task_48868;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private final String name;
    private final List<Role> availableRoles;
    private final List<Role> currentAvailableRoles;

    public House(String name, List<Role> availableRoles) {
        this.name = name;
        this.availableRoles = availableRoles;
        this.currentAvailableRoles = new ArrayList<>(availableRoles);
    }

    public synchronized void releaseRole(@NonNull Role role) {
        currentAvailableRoles.add(role);
        this.notifyAll();
    }

    public synchronized void reserveRole(@NonNull Role role) {
        currentAvailableRoles.remove(role);
    }

    @Override
    public String toString() {
        return name;
    }
}
