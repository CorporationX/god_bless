package school.faang.task_48839;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String role) {
        synchronized (house) {
            while (house.getCountAvaliableRoles() == 0) {
                try {
                    System.out.println(String.format("Waiting for a role...%s", name));
                    house.wait();

                    System.out.println("Resume...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.house = house;
            this.role = role;
            house.addRole();
            System.out.println(String.format("User %s has joined the house %s with role %s. Occupied roles: %d. "
                            + "Thread %s", name, house.getName(), role, house.getCountAvaliableRoles(),
                    Thread.currentThread().getName()));
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (!(house == null) && !(role == null)) {
                house.removeRole();
                System.out.println(String.format("User %s has leaved the house %s with role %s. Occupied roles: %d."
                                + "Thread %s", name, house.getName(), role, house.getCountAvaliableRoles(),
                        Thread.currentThread().getName()));
                System.out.println("Notify all users about roles...");
                house.notifyAll();
                this.house = null;
                this.role = null;
            }
        }
    }
}
