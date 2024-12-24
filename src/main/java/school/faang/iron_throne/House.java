package school.faang.iron_throne;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private final String name;
    private final List<String> roles = new ArrayList<>();

    public House(String name) {
        this.name = name;
    }

    public synchronized void addRole(String role) {
        roles.add(role);
        System.out.println("New role " + role + " added");
    }

    public synchronized String takeRole() {
        while (roles.size() == 0) {
            try {
                System.out.println("waiting..");
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        System.out.println("Role " + roles.get(0) + " taken");
        return roles.remove(0);
    }

    public synchronized void returnRole(String role) {
        roles.add(role);
        System.out.println("Role " + role + " returned");
        System.out.println("notifying");
        this.notify();
    }
}
