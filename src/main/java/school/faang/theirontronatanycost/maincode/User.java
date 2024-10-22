package school.faang.theirontronatanycost.maincode;

public class User {
    private String name;
    private String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            try {
                while (house.getRolesCount() == 0) {
                    System.out.println(name + "ждет роль");
                    house.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            house.addRole(this.role);
            System.out.println(name + " занял роль " + role);
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            house.removeRole(this.role);
            System.out.println(name + "освободил роль " + role);
        }
    }
}
