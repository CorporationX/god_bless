package school.faang.BJS2_61497;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class House {

    private final List<String> roles = new ArrayList<>(List.of("Lord", "Knight", "Wizard"));

    public String assignRole() {
        String str;
        synchronized (roles) {
            if (roles.isEmpty()) {
                try {
                    roles.wait();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            str = roles.remove(0);
        }
        return str;
    }

    public void releaseRole(@NonNull String role) {
        synchronized (roles) {
            roles.add(role);
            roles.notify();
        }
    }
}
