package school.faang.sprint3.task10;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private House house;
    private String role;

    private final Object lock = new Object();

    public User(String name) {
        this.setName(name);
    }

    public void joinHouse(House houseToJoin, String roleToGet) {
        synchronized (lock) {
            while (houseToJoin.getRolesAvailable() < 0) {
                System.out.println(name + " ждет, пока освободится роль в доме.");
                try {
                    houseToJoin.wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.fillInStackTrace();
                }
            }
            houseToJoin.removeRole();
            this.setHouse(houseToJoin);
            this.setRole(roleToGet);
            System.out.println(name + " вошел в дом " + houseToJoin.getName() + " как " + this.getRole());
        }
    }

    public void leaveHouse() {
        synchronized (lock) {
            System.out.println(name + " покинул дом " + this.getHouse().getName() + " как " + this.getRole());
            this.setHouse(null);
            this.setRole(null);
            this.house.addRole(this.role);
            house.notifyAll();
        }
    }
}
