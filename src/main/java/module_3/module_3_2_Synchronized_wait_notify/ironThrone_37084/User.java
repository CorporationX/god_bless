package module_3.module_3_2_Synchronized_wait_notify.ironThrone_37084;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    private final String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(@NonNull House house) {
        synchronized (house) {
            if (house.getCountAvailableRoles() <= 0) {
                System.out.println("Доступный ролей пока нет. Пользователь " + name + " ждет...");
                try {
                    System.out.println(name + " waiting ...");
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            this.house = house;
            house.addRole(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void leaveHouse(@NonNull House house) {
        synchronized (house) {
            if (role != null) {
                house.removeRole(this);
                System.out.println("Пользователь " + name + " покинул дом ");
                this.house = null;
                house.notifyAll();
            }
        }
    }
}
