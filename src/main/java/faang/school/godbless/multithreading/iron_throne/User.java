package faang.school.godbless.multithreading.iron_throne;

public class User {
    private String name;
    private House house;
    private String role;
    private static final Object lock = new Object();

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String role) {
        synchronized (lock) {
            if (house.getAvailableRoles().size() == 0) {
                System.out.printf("There are no free roles in the %s house\n", house.getName());
                return;
            }
            if (!house.getAvailableRoles().contains(role)) {
                System.out.printf("%s, %s is not available in the %s house. You can wait or choose another role.", name, role, house.getName());
                System.out.println(" Available roles: " + house.getAvailableRoles());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.house = house;
            this.role = role;
            house.removeAvailableRole(role);
            System.out.printf("%s became %s in the %s house\n", name, role, house.getName());
        }
    }

    public void leaveHouse() {
        synchronized (lock) {
            if (house == null || role.isBlank()) {
                System.out.printf("%s is not in any house\n", name);
                return;
            }
            house.addAvailableRole(role);
            System.out.printf("%s left role of %s in the %s house\n", name, role, house.getName());
            house = null;
            role = null;
            lock.notify();
        }
    }
}
