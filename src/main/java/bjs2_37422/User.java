package bjs2_37422;

public class User {
    private final String name;
    private House house;
    private String role;
    private final Object lock;

    public User(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    public void joinHouse(House house) {
        synchronized (lock) {
            while (!house.hasAvailableRole()) {
                try {
                    System.out.println(name + " wait role");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.house = house;
            role = house.addRole();
            System.out.println(name + " get role: " + role);
        }
    }

    public void leaveHouse() {
        if (house == null) return;

        synchronized (lock) {
            house.removeRole(role);
            System.out.println(name + " leave role: " + role);
            house = null;
            role = null;
            lock.notifyAll();
        }
    }
}
