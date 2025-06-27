package school.faang.module3.throne;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class House {
    @Getter
    private String name;
    private final List<String> roles;

    public House(String name, List<String> roles) {
        this.name = name;
        this.roles = new ArrayList<>(roles);
    }

    public synchronized String assignRole() {
        if (roles.isEmpty()) {
            try {
                System.out.printf("%s wait until any role will released\n", name);
                wait();
            } catch (InterruptedException e) {
                System.out.println("error until wait release role: " + e.getMessage());
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
