package school.faang.bjs249099;

public class User {

    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String role) {
        synchronized (house) {
            while (house.getAvailableRoleCount() == 0) {
                System.out.printf("%s is waiting for his role...\n", role);
                try {
                    house.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            house.removeRole();
            this.house = house;
            this.role = role;
            System.out.printf("%s joined %s with role %s\n", name, house.getName(), role);
        }
    }

    public void leaveHouse() {
        if (house == null) {
            System.out.println("User does not belong to any house");
            return;
        }
        synchronized (house) {
            house.addRole();
            System.out.printf("%s has left %s with role %s\n", name, house.getName(), role);
        }
    }

}
