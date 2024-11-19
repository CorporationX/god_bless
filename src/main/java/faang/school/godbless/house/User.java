package faang.school.godbless.house;

public class User implements Runnable {
    private final String name;
    private final House house;
    private String role;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse(String desiredRole) throws InterruptedException {
        synchronized (house) {
            while (!house.isRoleAvailable(desiredRole)) {
                System.out.println(name + " ждет освобождения роли: " + desiredRole);
                house.wait();
            }
            house.addRole(desiredRole, -1);
            this.role = desiredRole;
            System.out.println(name + " выбрал роль: " + role + " в доме " + house.getHouseName());
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (this.role != null) {
                house.removeRole(role);
                System.out.println(name + " покинул роль: " + role + " в доме " + house.getHouseName());
                this.role = null;
            }
        }
    }

    @Override
    public void run() {
        try {
            joinHouse("Лорд");
            Thread.sleep(5000);
            leaveHouse();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " был прерван.");
        }
    }
}
