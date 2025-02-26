package school.faang;

public class User extends Thread {
    private final String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            System.out.println(name + "выбрал роль" + assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                System.out.println(name + "Покидает дом и освобождает роль" + assignedRole);
                house.releaseRoel(assignedRole);
                assignedRole = null;
                house = null;
            }
        }
    }
}

