package faang.school.godbless.synchronization.task_6.model;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private String houseName = "free";
    private Role role = Role.FREE;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        if (role.equals(Role.FREE)) {
            String houseName = house.getName();
            Role assignedRole = house.assignRole();
            setRole(assignedRole);
            setHouseName(houseName);
            System.out.println(name + " стал " + assignedRole + " в  доме " + houseName);
        } else {
            System.out.println("у " + name + " уже есть роль в " + houseName);
        }
    }

    public void leaveHouse(House house) {
        if (role.equals(Role.FREE)) {
            System.out.println(name + " не может освободиться от роли так как он свободен");
        } else {
            house.makeRoleVacant(role);
            setHouseName("free");
            System.out.println(name + " покинул дом " + house.getName() + " и освободил роль " + getRole());
            setRole(Role.FREE);
        }
    }

    private void setRole(Role role) {
        this.role = role;
    }

    private void setHouseName(String houseName) {
        this.houseName = houseName;
    }
}