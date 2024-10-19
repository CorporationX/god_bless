package school.faang.ironthroneatallcosts;

public class User implements Runnable {

    private String name;
    private String houseName;
    private String role;
    private House house;

    public User(String name, House house, String houseName) {
        this.name = name;
        this.house = house;
        this.houseName = houseName;
    }

    public synchronized void joinHouse(String role) {
        this.role = role;
        synchronized (house) {
            while (!house.isRoleAvailable(role)) {
                try {
                    System.out.println(name + " is waiting for the role " + role + " in house " + houseName);
                    house.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            house.addRole(role);
        }
        System.out.println(name + " joined house " + houseName + " as " + role);
    }

    public synchronized void leaveHouse() {
        synchronized (house) {
            house.removeRole(role);
            System.out.println(name + " left the role " + role + " in house " + houseName);
            this.role = null;
        }
    }

    @Override
    public void run() {
        joinHouse("Lord");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        leaveHouse();
    }
}
