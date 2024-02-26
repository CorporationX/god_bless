package game_of_thrones;

public class User {
    private String name;
    private String house;
    private String role;
    private Object lock = new Object();
    private House houseInstance;

    public User(String name, String house, House houseInstance) {
        this.name = name;
        this.house = house;
        this.houseInstance = houseInstance;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getHouse() {
        return house;
    }

    public String getRole() {
        return role;
    }


    public void joinHouse(String role) throws InterruptedException {
        synchronized (lock) {
            for (String roles : houseInstance.getAvailableRole()) {
                if (roles.equals(role)) {
                    if (getHouse().equals("Lannister") && getRole() == null) {
                        if (houseInstance.getQuantityAvailableRoles() > 0) {
                            System.out.println(getName() + " now " + role);
                            setRole(role);
                            houseInstance.decreaseAvailableRoles();
                            houseInstance.removeAvailableRoles(role);
                        }
                    } else {
                        System.out.println("Role is taken. Waiting...");
                        lock.wait();
                    }
                }
            }
        }
    }

    public void leaveHouse() {
        synchronized (lock){
            String currentRole = getRole();
            setRole(null);

        }

    }

}