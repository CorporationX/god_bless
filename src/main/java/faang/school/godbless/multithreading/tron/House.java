package faang.school.godbless.multithreading.tron;

import lombok.Getter;

import java.util.List;

public class House {
    @Getter
    private List<String> availableRoles;
    @Getter
    private volatile int countAvailableRoles = 0;
    private final Object lock = new Object();

    public House(List<String> availableRoles) {
        this.availableRoles = availableRoles;
        this.countAvailableRoles = availableRoles.size();
    }

    public void addRole(String role) {
        availableRoles.remove(role);
        countAvailableRoles--;
    }

    public void removeRole(String role) {
        availableRoles.add(role);
        countAvailableRoles++;
    }
}
