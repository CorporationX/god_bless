package school.faang.throne;

import lombok.Data;

@Data
public class User implements Runnable {
    private final String name;
    private final House house;
    private String role;


    public void joinHouse(String role) throws InterruptedException {
        synchronized (house) {
            while (!house.isRoleAvailable(role)) {
                house.wait();
            }
            if (house.addRole(role)) {
                this.role = role;
                System.out.println(name + " присоединился к дому в роли " + role);
            }
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (role != null) {
                house.removeRole(role);
                System.out.println(name + " покинул дом и освободил роль " + role);
                role = null;
            }
        }
    }

    @Override
    public void run() {
        try {
            joinHouse("рыцарь");
            // Симуляция времени нахождения в доме
            Thread.sleep((long) (Math.random() * 1000));
            leaveHouse();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
