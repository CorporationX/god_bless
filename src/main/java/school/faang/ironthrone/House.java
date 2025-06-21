package school.faang.ironthrone;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class House {
    private final String houseName;
    private List<String> roles = new ArrayList<>(List.of("Lord", "Swordsman", "Archer", "Mage", "Alchemist"));

    public House(String houseName) {
        this.houseName = houseName;
    }

    public synchronized String assignRole(String role)  {
        while (!roles.contains(role)) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Во время ожидания освобождения роли произошла ошибка.");
                Thread.currentThread().interrupt();
            }
        }
        roles.remove(role);
        return role;
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        notifyAll();
    }
}
