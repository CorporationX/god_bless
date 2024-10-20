package school.faang.Multithreading.sprint_3.IronThrone;

import lombok.Getter;

@Getter

public class User {
    private final String name;
    private House house;
    private String role;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("У пользователя должно быть имя");
        }
    }

    public void joinHouse(House house, String role) {
        synchronized (house.getLockLeaveHouse()) {
            if (house.getRoleList().isEmpty() || !house.getRoleList().contains(role)) {
                System.out.println("Свободных ролей " + house.getRoleList() + " нет для пользователя " + name);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.println("Операция была прервана " + e.getMessage());
                }
            }
        }

        synchronized (house.getLockHouse()) {

//            if (!house.getRoleList().contains(role)) {
//                System.out.println("для пользователя " + this.name + " роль занята");
//                return;
//            }

            house.addRole(role);
            this.house = house;
            this.role = role;

            System.out.println("Пользователь " + this.name + " присоединился к дому " + this.house.getName() + " c еще "
                    + this.house.getRoleCounter() + " " + this.house.getRoleList() + " доступными местами \t\t с ролью " + this.role);
        }
    }

    public void leaveHouse(House house) {
        synchronized (house.getLockLeaveHouse()) {
            house.removeRole(this);
            this.house = null;
            this.role = null;
            System.out.println(name + " изгнан из дома " + house.getName() + "\t свободных мест "
                    + house.getRoleCounter() + " " + house.getRoleList());
            house.getLockLeaveHouse().notify();
        }
    }
}
