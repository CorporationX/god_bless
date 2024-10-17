package school.faang.ironthrone;


public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house) {
        synchronized (house) {
            try {
                while (house.getCountRoles() == 0) {
                    System.out.println(name + " ждет, пока освободится роль в доме");
                    house.wait();
                }
                String role = house.addRole();
                this.role = role;
                this.house = house;
                System.out.println(name + " занимает роль " + role);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void leaveHouse() {
        synchronized (house) {
            System.out.println(name + " покидает дом и освобождает роль " + role);
            house.removeRole(role);
            house.notifyAll();
        }
        this.house = null;
        this.role = null;
    }
}