package school.faang.ironthrone;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class House {
    private final List<String> roles;

    public synchronized String assignRole() throws InterruptedException {
        while (roles.isEmpty()) {
            wait();
        }
        return roles.remove(0);
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        notifyAll();
    }
}
