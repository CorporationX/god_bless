package bjs2_90348;

class User {
    private final String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        assignedRole = house.assignRole();
        this.house = house;
        System.out.printf("%s занял роль: %s%n", name, assignedRole);
    }

    public void leaveHouse() {
        if (house != null && assignedRole != null) {
            System.out.printf("%s покидает дом и освобождает роль: %s%n", name, assignedRole);
            house.releaseRole(assignedRole);
            assignedRole = null;
            house = null;
        }
    }
}