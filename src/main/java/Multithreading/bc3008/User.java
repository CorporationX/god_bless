package Multithreading.bc3008;

public class User {
    private String name;
    House house = new House();
    private String role;

    public void joinHouse() {

    }

    public void leaveHouse() {
        synchronized (role) {
            house = null;
            role = "";
        }

    }


}
