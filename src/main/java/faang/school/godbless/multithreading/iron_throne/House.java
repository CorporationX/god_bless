package faang.school.godbless.multithreading.iron_throne;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class House {
    @Getter
    private String name;
    private List<String> availableRoles;

    public House(String name) {
        this.name = name;
        availableRoles = new ArrayList<>(Arrays.asList("Lord", "Knight", "Mage"));
    }

    private void removeAvailableRole(String role) {
        availableRoles.remove(role);
    }

    private void addAvailableRole(String role) {
        availableRoles.add(role);
    }

    public synchronized void selectRole(String role) {
        while (!availableRoles.contains(role)) {
            System.out.printf("%s is not available in the %s house. Wait..\n", role, name);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        removeAvailableRole(role);
    }

    public synchronized void releaseRole(String role) {
        addAvailableRole(role);
        notifyAll();
    }
}
