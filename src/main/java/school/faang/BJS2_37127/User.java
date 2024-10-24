package school.faang.BJS2_37127;

public class User implements Runnable {
    private final String name;
    private final House house;
    private String chosenRole;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse() throws InterruptedException {
        synchronized (house) {
            while (house.getAvailableRoleCount() == 0) {
                System.out.println(name + " ждет, пока освободится роль в доме.");
                house.wait();
            }
            String role = house.addRole();
            if (role != null) {
                chooseRole(role);
                System.out.println(name + " выбрал роль: " + role);
            }
        }
    }

    public void leaveHouse() {
        System.out.println(name + " покидает дом и освобождает роль: " + chosenRole);
        house.removeRole(chosenRole);
        chosenRole = null;
    }

    private void chooseRole(String role) {
        chosenRole = role;
    }

    @Override
    public void run() {
        try {
            joinHouse();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(name + " был прерван.");
            e.printStackTrace();
        } finally {
            leaveHouse();
        }
    }
}
