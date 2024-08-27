package faang.school.godbless.BJS2_24106;

public class User {
    private String name;
    private String role;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String chosenRole) {
        synchronized (house) {
            while (house.getCountOfAvailableRoles() == 0) {
                System.out.println("There is no any available role");
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.house = house;
            while (house.getAvailableRoles().get(chosenRole).equals(Boolean.FALSE)) {
                System.out.println("The role '" + chosenRole + "' is not available now");
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            role = chosenRole;
            house.addRole(chosenRole);
            System.out.println(name + " joined house with role '" + role + "'");
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole(role);
            house = null;
            role = null;
            System.out.println(name + " left house");
        }
    }
}