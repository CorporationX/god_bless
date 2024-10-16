package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private House house;
    private String preferedRole;
    private String takedRole;
    private static final int TIME_BETWEEN_ATTEMPTS = 300;
    private static final int TIME_OF_BEENG_IN_THE_HOUSE = 20;

    public User(String name, String preferedRole) {
        this.name = name;
        this.preferedRole = preferedRole;
    }

    public void joinHouse(House house, String role)
                                                 throws InterruptedException {
        synchronized (house) {
            if (house.getAccessibleRoles().contains(role)) {
                this.house = house;
                this.takedRole = role;
                System.out.println("Дом " + house.getName() +
                        " принял игрока " + this.name + " в роли " + role);
                house.addRole(this);

                house.wait(TIME_OF_BEENG_IN_THE_HOUSE);
                this.leaveHouse(house);
            } else {
                while (!house.getAccessibleRoles().contains(role)) {
                    System.out.println("Дом " + house.getName() +
                        " не может принять игрока " + this.name +
                        " в роли " + role);
                    house.wait(TIME_BETWEEN_ATTEMPTS);
                }
            }
        }
    }

    public void leaveHouse(House house) {
        synchronized (house.getAccessibleRoles()) {
            house.removeRole(this);
            takedRole = null;
            house.notifyAll();
        }
    }

}
