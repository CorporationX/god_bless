package faang.school.godbless.synchronization.task_6.model;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private House house;
    private Role role = Role.FREE;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        if (role.equals(Role.FREE)) {
            this.house = house;
            Role assignedRole = house.assignRole();
            setRole(assignedRole);
            System.out.println(name + " стал " + assignedRole + " в  доме " + house.getName());
        } else {
            System.out.println("у " + name + " уже есть роль в " + this.house.getName());
        }
    }

    public void leaveHouse(House house) {
        if (role.equals(Role.FREE)) {
            System.out.println(name + " не может освободиться от роли так как он свободен");
        } else {
            house.makeRoleVacant(role);
            this.house = null;
            System.out.println(name + " покинул дом " + house.getName() + " и освободил роль " + getRole());
            setRole(Role.FREE);
        }
    }

    private void setRole(Role role) {
        this.role = role;
    }
}