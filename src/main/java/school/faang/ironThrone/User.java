package school.faang.ironThrone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private String role;
    final Object lock = new Object();

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            while (house.getAvailableRoleCount() < 1) {
                System.out.println(getName() + " ожидает свободное место...");
                house.wait();
            }
            this.role = house.addRole();
            System.out.println(getName() + " выбрал роль - " + getRole());
        }
    }

    public synchronized void leaveHouse(House house){
        synchronized (house){
            if (getRole() != null){
                System.out.println(getName() + " покинул дом и освободил роль: " + getRole());
                house.releaseRole(getRole());
                setRole(null);
                house.notifyAll();
            }
        }
    }
}
