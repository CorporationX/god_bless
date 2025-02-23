package school.faang.task_61521;

import lombok.Setter;

@Setter
public class User {
    private final String name;
    private  String assignedRole;
    private  House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            System.out.println(name + " выбрал роль: " + assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                System.out.println(name + " покидает дом и освобождает роль: " + assignedRole);
                house.releaseRole(assignedRole); // Освобождаем роль
                assignedRole = null; // Сбрасываем роль
                house = null; // Сбрасываем дом
            }
        }
    }
}
