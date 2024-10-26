package school.faang.BJS237079;

public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) throws InterruptedException {
           synchronized (house) {
               while (house.getAvailableRoleCount() == 0) {
                   System.out.println(name + " ждет, пока освободиться роль в доме");
                   house.wait();
               }
           }
            role = house.addRole();
            if (role != null) {
                System.out.println(name + " выбрал роль: " + role);
            }
    }

    public synchronized void leaveHouse() {
        if (role!= null && !role.isEmpty()) {
            System.out.println(name + " покинул дом: " + house + " освободил роль " + role);
            house.removeRole(role);
            role = null;
        }
    }
}


