package school.faang.BJS2_37096;

import lombok.Data;

@Data
public class User implements Runnable {
    private String name;
    private String role;
    private House house;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse() throws InterruptedException {
        synchronized (house) {
            while (house.getNumberOfRoles() == 0) {
                System.out.println(name + " ожидает, пока освободится роль");
                house.wait();
            }
            this.role = house.addRole();
            System.out.println(name + " становится " + role);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            System.out.println(name + " покидает дом и освобождает роль " + role);
            house.removeRole(role);
        }
    }

    @Override
    public void run() {
        try {
            joinHouse();
            Thread.sleep(4000);
            leaveHouse();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

