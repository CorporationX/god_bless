package the_iron_throne_at_any_cost;

public class User {
    private String name;
    private House house;
    private String selectedRole;
    private boolean willBeDead;

    public boolean isWillBeDead() {
        return willBeDead;
    }

    public String getName() {
        return name;
    }

    public User(String name, boolean willBeDead) {
        this.willBeDead = willBeDead;
        this.name = name;
        house = null;
        selectedRole = null;
    }

    public synchronized void joinHouse(House house, String role) {
        try {
            while (!house.hasAvailableRole()) {
                wait();
            }

            this.house = house;
            selectedRole = role;
            house.addRole(role);
            System.out.println(name + " joined House " + house.getName() + " as " + role);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void leaveHouse() {
        try {
            if (house != null) {
                house.removeRole(selectedRole);
                house = null;
                selectedRole = null;
                System.out.println(name + " left house");
            } else {
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        notifyAll();
    }
}
