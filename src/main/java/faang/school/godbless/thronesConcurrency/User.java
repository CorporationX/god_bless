package faang.school.godbless.thronesConcurrency;

public class User {

    private static final Object lock = new Object();
    private final String name;
    private String role;
    private final House house;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse() {
        System.out.println("User " + this.name + " trying to get a new role");
        try {
            synchronized (lock) {
                while (!house.isAvailablePlaces()) {
                    System.out.println("User " + this.name + " is in waiting while new role isn't available");
                    lock.wait();
                }
                this.role = house.addRole();
            }
        } catch (InterruptedException ie) {
            System.out.println("InterruptedException in joinHouse method");
        }
        System.out.println("User " + this.name + " get role " + this.role);
    }

    public void leaveHouse() {
        System.out.println("User " + this.name + " trying to lost his role " + this.role);
        synchronized (lock) {
            house.removeRole(this.role);
            this.role = "";
            lock.notifyAll();
        }
        System.out.println("User " + this.name + " lost his role");
    }
}
