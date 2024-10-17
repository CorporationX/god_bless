package school.faang.ironthrone;

import lombok.Getter;

public class User {
    @Getter
    private String name;
    private House house;
    private String chosenRole;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house) throws InterruptedException {
        this.house = house;
        synchronized (house) {
            while (house.getAvailableRolesInHouse() == 0) {
                System.out.println("Все роли заняты");
                house.wait();
            }
            chosenRole = house.addRole();
            System.out.println(name + " выбрал роль " + chosenRole);
        }
    }

    public synchronized void leaveHouse() {
        if (chosenRole != null) {
            System.out.println(name + " покидает дом освобождая роль " + chosenRole);
            house.removeRole(chosenRole);
            chosenRole = null;
        }
    }
}