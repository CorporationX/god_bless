package school.faang.the_iron_throne_at_any_cost.BJS2_61550;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@AllArgsConstructor
@Getter
public class House {
    private static final Logger LOGGER = LoggerFactory.getLogger(House.class);

    private final List<String> roles;

    public synchronized String assignRole() {
        String role = roles.get(0);
        roles.remove(role);

        LOGGER.info("Дом назначает роль: {}", role);
        return role;
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        notify();

        LOGGER.info("В дом возвращается роль: {}", role);
    }
}
