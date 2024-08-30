package threadtwo.six;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
public class User {

    private String name;
    private String houseName;
    private String houseRole;
    private Random random = new Random();

    public User(String name) {
        this.name = name;
        this.houseName = " ";
        this.houseRole = " ";
    }

    public void joinHouse(House house) {
        synchronized (house) {
            while (!house.isHaveFreeRole()) {
                try {
                    System.out.println("There are currently no free roles in the house.");
                    house.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Home join interrupted.");
                    return;
                }
            }
            houseName = house.getName();
            addRole(house);
            house.assignRole(houseRole);
            System.out.println(name + " joined the house " + house.getName() + " as a " + houseRole);
        }
    }

    public void addRole(House house) {
        synchronized (house) {
            List<String> freeRoleList = house.getListFreeRole();
            houseRole = freeRoleList.get(random.nextInt(freeRoleList.size()));
        }
    }

    public void removeRole(House house) {
        synchronized (house) {
            house.releaseRole(houseRole);
            houseName = null;
            houseRole = null;
            house.notifyAll();
        }
    }

}
