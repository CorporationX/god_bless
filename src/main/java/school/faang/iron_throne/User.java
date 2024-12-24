package school.faang.iron_throne;

public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        this.house = house;
        this.role = house.takeRole();
        System.out.println(this.name + " joined " + house.getName());
    }

    public void leaveHouse() {
        System.out.println(this.name + " left " + house.getName());
        house.returnRole(role);
        this.role = null;
        this.house = null;
    }
}
