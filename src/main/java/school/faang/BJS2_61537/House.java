package school.faang.BJS2_61537;

import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class House {

    private final List<String> roles;

    public House(List<String> roles) {
        this.roles = new ArrayList<>(roles);
    }

    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return roles.remove(0);
    }

    public synchronized void releaseRole(@NonNull String role) {
        roles.add(role);
        notifyAll();
    }
}
