package iron_throne;

import lombok.SneakyThrows;

public class User {
    private final String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    @SneakyThrows
    public void joinHouse(House house) {
        synchronized (house) {
            while (!house.hasAvailableRoles()) {
                house.wait();
            }
            this.house = house;
            this.role = house.selectRole();
            System.out.println(name + " joined house " + house.getName() + " as " + role);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null) {
                house.addRole(role);
                System.out.println(name + " left house " + house.getName() + " and role " + role);
                house = null;
                role = null;
                house.notifyAll();
            }
        }
    }
}