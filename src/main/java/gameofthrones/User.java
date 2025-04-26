package gameofthrones;

import lombok.Setter;

public class User implements Runnable {
    private String name;
    @Setter
    private House house;
    private String assingedRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            assingedRole = house.assignRole();
            this.house = house;
            System.out.println(name + " joined the " + assingedRole + " house");
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assingedRole != null) {
                System.out.println(name + " is leaving house and releasing the role" + house.assignRole());
                house.releaseRole(assingedRole);
                assingedRole = null;
                house = null;
            }
        }
    }

    @Override
    public void run() {
        joinHouse(house);
        try {
            Thread.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        leaveHouse();
    }

}
