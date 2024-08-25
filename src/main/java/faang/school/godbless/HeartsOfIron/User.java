package faang.school.godbless.HeartsOfIron;

public class User {
    private String name;
    private String role;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house) {
        role = house.removeRole();
        this.house = house;
        System.out.println(name + " присоеденился к дому с ролью: " + role);
    }

    public synchronized void leaveHouse() {
        if (role != null && house != null) {
            house.addRole(role);
            System.out.println(name + " покинул дом и освободил роль: " + role);
            role = null;
        }
    }

}
