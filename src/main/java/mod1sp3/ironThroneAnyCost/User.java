package mod1sp3.ironThroneAnyCost;

import lombok.Data;

@Data
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String role) {
        synchronized (house.getLock()) {
            while (!house.getAvailableRoles().contains(role)) {
                System.out.println(this.name + " - ждёт освобождения роли");
                try {
                    house.getLock().wait();
                } catch (InterruptedException e) {
                    throw new IllegalStateException("wait error: " + e.getMessage(), e);
                }
            }
            this.house = house;
            this.role = role;
            house.removeAvailableRole(role);
        }
    }

    public void leaveHouse() {
        synchronized (house.getLock()) {
            house.addAvailableRole(this.role);
            this.role = null;
            this.house = null;
        }
    }
}
