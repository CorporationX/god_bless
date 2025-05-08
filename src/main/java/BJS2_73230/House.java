package BJS2_73230;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class House {
    private final Map<String, Boolean> roles = new HashMap<>();

    public House(final List<String> roles) {
        for (String role : roles) {
            this.roles.put(role, false);
        }
    }

    public synchronized void assignRole(final String role) {
        this.roles.put(role, true);
    }

    public synchronized void releaseRole(final String role) {
        this.roles.put(role, false);
    }

    public synchronized Optional<String> takeFreeRole() {
        for (Map.Entry<String, Boolean> entry : this.roles.entrySet()) {
            if (!entry.getValue()) {
                assignRole(entry.getKey());
                return Optional.of(entry.getKey());
            }
        }

        return Optional.empty();
    }
}

