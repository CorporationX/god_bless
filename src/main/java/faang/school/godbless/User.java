package faang.school.godbless;

public class User {
    private String name;
    private House house;
    private String selectedRole;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
        this.selectedRole = null;
    }

    public  void joinHouse() {
        synchronized (house) {
            while (!house.hasAvailableRoles()) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            selectedRole = house.getAvailableRole();
            house.removeRole(selectedRole);
            System.out.println(name + " joined " + house + " as " + selectedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.addRole(selectedRole);
            System.out.println(name + " left " + house + " and released " + selectedRole);
            selectedRole = null;
            house.notifyAll();
        }
    }
}
