package faang.school.godbless.iron_tron;


import lombok.Data;

@Data
public class User {
    private String name;
    private String house;
    private String role;

    public void joinHouse(House house) {
        synchronized (house.getLock()) {
            while (house.getQuantityAvailableRoles() == 0) {
                System.out.println("There are no free roles. Please wait");
                try {
                    house.getLock().wait();
                } catch (InterruptedException e) {
                    System.out.println("They don't want to wait");
                }
            }
            house.addRole(this);
        }
    }

    public synchronized void leaveHouse(House house) {
        synchronized (house.getLock()) {
            if (this.house != null) {
                System.out.printf("%s leave the house of %s and frees up the role %s \n", name, this.house, role);
                setHouse(null);
                house.removeRole(role);
            }
        }
    }

    public User(String name) {
        this.name = name;
    }
}


