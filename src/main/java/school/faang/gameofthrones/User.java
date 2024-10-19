package school.faang.gameofthrones;

public class User {
    private final String name;
    private String houseName;
    private String roleName;

    public User(String name) {
        this.name = name;
        this.houseName = "";
        this.roleName = "";
    }

    public synchronized void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            while (house.getAvailableRolesCount() <= 0) {
                house.wait();
            }
            this.roleName = house.addRole();
            this.houseName = house.getName();
            System.out.println("User: " + name + " joined the House: " + houseName + " and has role " + roleName);
        }
    }

    public synchronized void leaveHouse(House house) {
        synchronized (house) {
            house.removeRole(roleName);
            System.out.println("User: " + name + " left the House: " + houseName + " and Role: " + roleName);
            this.houseName = "";
            this.roleName = "";
            house.notifyAll();
        }
    }
}
