package faang.school.godbless.HeartsOfIron;

public class User {
    private String name;
    private String choosedRole;
    private House connectedHouse;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house) {
        choosedRole = house.removeRole();
        connectedHouse = house;
        System.out.println(name + " присоеденился к дому с ролью: " + choosedRole);
    }

    public synchronized void leaveHouse() {
        if (choosedRole != null && connectedHouse != null) {
            connectedHouse.addRole(choosedRole);
            System.out.println(name + " покинул дом и освободил роль: " + choosedRole);
            choosedRole = null;
        }
    }

}
