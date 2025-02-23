package school.faang.BJS2_61497;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class House {

    private final List<Role> roles = new ArrayList<>(List.of(Role.LORD, Role.KNIGHT, Role.WIZARD));

    public synchronized Role assignRole() {
        Role role;
        while (roles.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        role = roles.remove(0);
        return role;
    }

    public synchronized void releaseRole(@NonNull Role role) {
        roles.add(role);
        this.notify();
    }
}
