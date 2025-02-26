package school.faang;

import java.util.ArrayList;
import java.util.List;

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
                System.err.println("Ошибка при ожидании роли" + e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return roles.remove(0);
    }

    public synchronized void releaseRoel(String role) {
        roles.add(role);
        notifyAll();
    }
}



