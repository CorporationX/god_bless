package faang.school.godbless.sprint3.ironThrone;

import java.util.List;

public class House {

    private String name;
    private List<Role> availableRoles;
    private Integer amountOfAvailableRoles;
    private final Object lock = new Object();

    public House(String name, List<Role> availableRoles, Integer amountOfAvailableRoles) {
        this.name = name;
        this.availableRoles = availableRoles;
        this.amountOfAvailableRoles = amountOfAvailableRoles;
    }

    public void addRole() {
        System.out.println("before adding house " + name);
        synchronized (lock) {
            System.out.println("adding house " + name);
            System.out.println("amount of available roles: " + amountOfAvailableRoles);
            amountOfAvailableRoles--;
            System.out.println("amount of available roles after adding: " + amountOfAvailableRoles);
            lock.notifyAll();
        }
    }

    public void removeRole() {
        System.out.println("before removing from house " + name);
        synchronized (lock) {
            System.out.println("removing from house " + name);
            System.out.println("amount of available roles: " + amountOfAvailableRoles);
            amountOfAvailableRoles++;
            System.out.println("amount of available roles after deleteing: " + amountOfAvailableRoles);
            lock.notifyAll();
        }
    }

    public String getName() {
        return name;
    }

    public boolean houseHaveFreePlaces() {
        synchronized (lock) {
            System.out.println("amount of available places: " + amountOfAvailableRoles);
            return amountOfAvailableRoles > 0;
        }
    }

    public boolean isHouseHaveRole(Role role) {
        return availableRoles.contains(role);
    }

    public void waitAvailableRole() throws InterruptedException {
        synchronized (lock) {
            lock.wait();
        }
    }

    public Object getLock() {
        return lock;
    }
}
