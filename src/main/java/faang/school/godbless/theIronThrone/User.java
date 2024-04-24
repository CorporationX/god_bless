package faang.school.godbless.theIronThrone;

import lombok.Data;

@Data
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House setHouse) {
        synchronized (setHouse) {
            while (!setHouse.checkForEmptyRole()) {
                try {
                    System.out.println("No empty roles in house of " + setHouse.getName() + " for " + name);
                    setHouse.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int random = (int) (Math.random() * setHouse.getAmountOfEmptyRoles());
            String setRole = setHouse.getEmptyRoles().get((random));
            house = setHouse;
            role = setRole;
            setHouse.removeRole(setRole);
            System.out.println(name + " has joint to house of " + setHouse.getName() + " as " + setRole);
        }
    }

    public void leaveHouse() {
        synchronized (house){
            house.addRole(role);
            System.out.println(name + " has left the house of " + house.getName() + " and the the role of " + role);
            this.house = null;
            role = null;
        }
    }
}
