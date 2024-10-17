package school.BJS2_37070;

public class User {

    private String name;
    private String house;
    private String role;

    public User(String name, String house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            if (house.getAvailableRole() == 0) {
                System.out.println("Ожидание пока освободится роль");
                house.wait();
            }
            String role = house.addRole();
            System.out.println("Пользователь " + name + " выбрал роль " + role);
        }
    }

    public void leaveHouse(House house) throws InterruptedException {
        Thread.sleep(5000);
        synchronized (house) {
            System.out.println("Роль освобождается");
            house.removeRole();
        }
    }

}