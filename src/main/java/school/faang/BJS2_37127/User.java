package school.faang.BJS2_37127;

public class User implements Runnable {
    private final String username;
    private final House house;
    private String chosenRole;

    public User(String username, House house) {
        this.username = username;
        this.house = house;
    }

    public void joinHouse(String role) {
        synchronized (house) {
            while (house.getCurrentAvailableRoles() == 0 || !house.addRole(role)) {
                try {
                    System.out.println(username + " ждет, пока освободится роль " + role + ".");
                    house.wait();
                } catch (InterruptedException e) {
                    System.out.println(username + " был прерван.");
                    e.printStackTrace();
                }
            }
            chosenRole = role;
            System.out.println(username + " присоединился к дому с ролью " + role + ".");
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (chosenRole != null) {
                house.removeRole(chosenRole);
                System.out.println(username + " покинул дом и освободил роль " + chosenRole + ".");
                chosenRole = null;
            }
        }
    }

    @Override
    public void run() {
        joinHouse("Рыцарь");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(username + " был прерван во время пребывания в доме.");
            e.printStackTrace();
        } finally {
            leaveHouse();
        }
    }
}
