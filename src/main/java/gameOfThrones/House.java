package gameOfThrones;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private String name;
    private final List<String> roles;

    public House(String name, List<String> roles) {
        this.name = name;
        this.roles = new ArrayList<>(roles);
    }

    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Ошибка при ожидании роли: ", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return roles.remove(0);
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        notifyAll();
    }
}
