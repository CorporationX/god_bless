package school.faang.iron_throne_at_all_costs;

public class User {
    private String name;
    private String assignedRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (this) {
            this.assignedRole = house.assignRole(this.name);
            this.notifyAll();
        }
    }

    public void leaveHouse(House house) {
        synchronized (this) {
            while (this.assignedRole == null) {
                System.out.println("User " + this.name + ", you can't leave house, " +
                        "because you're haven't joined to some yet");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("User " + this.name + " leave " + house.getName());
            house.releaseRole(this.assignedRole);
        }
    }
}
