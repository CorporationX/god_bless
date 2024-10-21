package school.faang.ironthroneatanycost;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Runnable {
    private final String username;
    private House house;
    private String chosenRole;

    public User(String username) {
        this.username = username;
    }

    public void joinHouse(House house, String role) {
        synchronized (house) {
            while (!house.addRole(role)) {
                try {
                    System.out.println(username + " is waiting for role: " + role + " in house: " + house.getName());
                    house.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(username + " was interrupted while waiting.");
                }
            }
            this.house = house;
            this.chosenRole = role;
            System.out.println(username + " joined " + house.getName() + " as a " + role);
        }
    }

    public void leaveHouse() {
        if (house != null && chosenRole != null) {
            synchronized (house) {
                house.removeRole(chosenRole);
                System.out.println(username + " left " + house.getName() + " and freed role: " + chosenRole);
                this.house = null;
                this.chosenRole = null;
            }
        }
    }

    @Override
    public void run() {
        joinHouse(house, chosenRole);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        leaveHouse();
    }
}

