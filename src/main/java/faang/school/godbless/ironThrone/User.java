package faang.school.godbless.ironThrone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private String name;
    private final House house;
    private String selectedRole;
    private String houseName;

    public User(String name, House house, String houseName) {
        this.name = name;
        this.house = house;
        this.selectedRole = null;
        this.houseName = houseName;
    }

    public void joinHouse() {
        synchronized (house) {
            while (!house.hasAvailableRoles()) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String selectedRole = house.getAvailableRole();
            setSelectedRole(selectedRole);
            house.removeRole(selectedRole);
            System.out.println(getName() + " from " + houseName + " joined the house as " + getSelectedRole());
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        leaveHouse();
    }

    public void leaveHouse() {
        synchronized (house) {
            house.addRole(selectedRole);
            selectedRole = null;
            house.notifyAll();
        }
        System.out.println(name + " from " + houseName + " left the house");
    }
}
