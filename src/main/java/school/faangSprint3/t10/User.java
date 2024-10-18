package school.faangSprint3.t10;

import lombok.Setter;

@Setter
public class User implements Runnable {
    private String name;
    private House house;
    private String chosenRole;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            while (house.getAvailableRoleCount() == 0) {
                System.out.println(name + " ждет, пока освободится роль в доме " + house.getName());
                house.wait();
            }
            this.house = house;
            this.chosenRole = house.addRole();
            System.out.println(name + " присоединился к дому " + house.getName() + " с ролью: " + chosenRole);
        }
    }

    public synchronized void leaveHouse() {
        if (house != null) {
            synchronized (house) {
                System.out.println(name + " покидает дом " + house.getName() + " и освобождает роль: " + chosenRole);
                house.removeRole(chosenRole);
                house.notifyAll();
                this.house = null;
                this.chosenRole = null;
            }
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 2000));
            joinHouse(house);
            Thread.sleep((long) (Math.random() * 3000));
            leaveHouse();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}