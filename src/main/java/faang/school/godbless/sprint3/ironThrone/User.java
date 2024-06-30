package faang.school.godbless.sprint3.ironThrone;

public class User {

    private String name;
    private House house;
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, Role role) {

        try {
            if (house.isHouseHaveRole(role)) {
                System.out.println("user " + name + " before adding in house " + house.getName());
                synchronized (house.getLock()) {
                    while (!house.houseHaveFreePlaces()) {
                        System.out.println("user " + name + " waiting adding in house " + house.getName());
                        house.waitAvailableRole();
                    }

                    System.out.println("user " + name + " adding in house " + house.getName());

                    this.house = house;
                    this.role = role;
                    house.addRole();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void leaveHouse() {
        System.out.println("user " + name + " before removing from house " + house.getName());
        synchronized (this.house.getLock()) {
            System.out.println("user " + name + "  removing from house " + house.getName());
            this.house.removeRole();
            this.house = null;
            this.role = null;
        }
    }
}
