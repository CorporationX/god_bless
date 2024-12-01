package ironthrone;

import lombok.Data;

@Data
public class User {
    private String name;
    private House house;
    private String desiredRole;

    public User(String name, House house, String desiredRole) {
        if (!house.getRoles().contains(desiredRole)) {
            throw new IllegalArgumentException("В доме нет такой роли.");
        }

        this.name = name;
        this.house = house;
        this.desiredRole = desiredRole;
    }

    public void joinHouse() {
        synchronized (house) {
            if (house.getAvailableRoleCount() == 0) {
                System.out.println(name + " ждет пока освободится роль в доме.");
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException("Что-то пошло не так при вызове метода wait().");
                }
            }
            house.addRole();
            System.out.println(name + " получил роль: " + desiredRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house.getAvailableRoleCount() < house.getRoles().size()) {
                System.out.println(name + " покидает дом и освобождает роль.");
                house.removeRole();
                house.notifyAll();
            }
        }
    }
}
