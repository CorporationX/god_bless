package school.faang.ironThrone;

import lombok.Getter;
import lombok.Setter;
import school.faang.ironThrone.House;

@Getter
@Setter
public class User {
    private String name;
    private House house;
    private String preferedRole;
    private String takedRole;
    private int timeBetweenAttempts = 300;
    private int timeOfBeengInTheHouse = 20;

    public User(String name, String preferedRole) {
        this.name = name;
        this.preferedRole = preferedRole;
    }

    public void joinHouse(House house, String role)
                                                 throws InterruptedException {
        synchronized (house) {
            while (!house.getAccessibleRoles().contains(role)) {
                System.out.println("Дом " + house.getName() +
                        " не может принять игрока " + this.name +
                        " в роли " + role);
                house.wait(timeBetweenAttempts);
            }
            this.house = house;
            this.takedRole = role;
            System.out.println("Дом " + house.getName() +
                    " принял игрока " + this.name + " в роли " + role);
            house.addRole(this);
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            System.out.println("игрок "  + this.name + " освобождает роль " +
                    this.takedRole + " в доме " + house.getName());
            house.removeRole(this);
            takedRole = null;
            house.notifyAll();
        }
    }

}
