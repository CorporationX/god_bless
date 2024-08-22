package faang.school.godbless.thirdsprint.ironthrone;

public class User {
    private final String name;
    private House house;
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, Role role) {
        synchronized (house) {
            while (!house.isRoleAvailable(role)) {
                System.out.println(name + " is waiting for an available " + role + "'s slot in house " + house.getName());
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.house = house;
            this.role = role;
            house.addRole(role);
            System.out.println(name + " joined house " + house.getName() + " as " + role +
                    ". Available slots left: " + house.getRolesMap().get(role));;

        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && role != null) {
                house.removeRole(role);
                System.out.println(name + " left house " + house.getName() +
                        " and made available a " + role + "'s position." +
                        " Available slots left: " + house.getRolesMap().get(role));
                this.house = null;
                this.role = null;
            }
        }
    }
}
