package school.faang.module3.throne;

public class User {
    private String name;
    private String assignedRole;
    private House house;
    private Object lock = new Object();

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (lock) {
            System.out.printf("%s try to join to house %s\n", name, house.getName());
            assignedRole = house.assignRole();
            this.house = house;
            System.out.printf("%s joined to house %s\n", name, house.getName());
        }
    }

    public void leaveHouse() {
        synchronized (lock) {
            if (house != null) {
                house.releaseRole(assignedRole);
                System.out.printf("%s leaved house %s\n", name, house.getName());
            }
        }
    }
}
