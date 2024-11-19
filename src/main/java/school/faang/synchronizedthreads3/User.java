package school.faang.synchronizedthreads3;

public class User extends Thread {
    private String username;
    private House house;
    private String role;

    public User(String username) {
        this.username = username;
    }


    public void joinHouse(House house) {
        this.house = house;
        synchronized (house) {
            while (!house.hasAvailableRoles()) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            role = house.assignRole();
            house.removeRole();
            System.out.println(username + " has joined house and is now a " + role);
        }
    }


    public void leaveHouse() {
        synchronized (house) {
            if (role != null) {
                house.addRole();
                System.out.println(username + " has left the house and freed the role of " + role);
                role = null;
            }
            house.notifyAll();
        }
    }

    @Override
    public void run() {

        joinHouse(house);
        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        leaveHouse();
    }
}
