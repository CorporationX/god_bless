package faang.school.godbless.thronesConcurrency;

import lombok.NonNull;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class House {

    private final Object availablePlacesLock = new Object();
    private final List<String> availableRoles;
    private final String name;
    private int availablePlaces;

    public House(@NonNull String name, @NonNull List<String> availableRoles) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name of house couldn't be blank");
        }
        this.name = name;
        this.availableRoles = availableRoles;
        this.availablePlaces = availableRoles.size();
    }

    public String addRole() {
        synchronized (availablePlacesLock) {
            String availableRole = availableRoles.get(ThreadLocalRandom.current().nextInt(availableRoles.size()));
            availableRoles.remove(availableRole);
            availablePlaces--;
            return availableRole;
        }
    }

    public void removeRole(@NonNull String role) {
        synchronized (availablePlacesLock) {
            availableRoles.add(role);
            availablePlaces++;
            availablePlacesLock.notifyAll();
        }
    }

    public boolean isAvailablePlaces() {
        synchronized (availablePlacesLock) {
            return availablePlaces > 0;
        }
    }
}
