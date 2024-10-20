package ru.kraiush.BJS2_37102;

public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
        this.house = null;
        this.role = null;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public synchronized void joinHouse(House house) {
        synchronized (house) {
            setHouse(house);
            while (house.getAvailableRolesCount() == 0) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            role = house.addRole();
            System.out.println(name + " got a role: " + role);
        }
    }

    public synchronized void leaveHouse() {
        synchronized (house) {
            house.removeRole(role);
            System.out.println(name + " left the House and released the role: " + role);
            house.notifyAll();
        }
    }
}
