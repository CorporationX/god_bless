package school.faang.multithreading.synchron.iron.throne.any.cost;

import lombok.SneakyThrows;

public class User {
    private String name;
    private String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @SneakyThrows
    public void joinHouse(House house) {
        synchronized (house) {
            if (!house.getAvailableRoles().contains(this.role)) {
                System.out.println(name + " ждет, когда освободится роль " + role);
                house.wait();
            }
            house.addRole(this.role);
            System.out.println(name + " занял роль " + role);
        }
    }

    @SneakyThrows
    public void leaveHouse(House house) {
        synchronized (house) {
            house.removeRole(this.role);
            System.out.println(name + " освободил роль " + role);
        }
    }
}
