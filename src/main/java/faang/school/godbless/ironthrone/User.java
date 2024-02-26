package faang.school.godbless.ironthrone;

import lombok.Data;

@Data
public class User {

    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(String role, House house) {
        roleAndHouseValidate(role, house);
        synchronized (house) {
            while (house.getFreeRolesCnt() == 0) {
                try {
                    System.out.println(String.format("%s is waiting to join house %s", getName(), house.getName()));
                    house.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            house.addRole(role);
            this.role = role;
            this.house = house;
            System.out.println(String.format("%s joined house %s", getName(), house.getName()));
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole(this.role);
            System.out.println(String.format("%s is left house %s", getName(), house.getName()));
            house.notifyAll();
            this.role = null;
            this.house = null;
        }
    }

    private void roleAndHouseValidate(String role, House house) {
        if (role == null) {
            throw new IllegalArgumentException("Role can't be null");
        }
        if (role.isEmpty()) {
            throw new IllegalArgumentException("Role can't be empty");
        }
        if (house == null) {
            throw new IllegalArgumentException("House can't be null");
        }
    }
}
