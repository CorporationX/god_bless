package school.faang.BJS2_37120;

import static java.lang.System.out;

public class User implements Runnable{
    private final String name;
    private final House house;
    private String chosenRole;

    public User(String name, House house){
        this.name = name;
        this.house = house;
    }

    public void run() {
        try {
            joinHouse();
            Thread.sleep(1000);
            leaveHouse();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void joinHouse() throws InterruptedException {
        synchronized (house) {
            while (house.getAvailableRoleCount() == 0) {
                out.printf("%s ждет, пока роль в доме не выбрана.\n", name);
                house.wait();
            }
            chosenRole = house.addRole();
            out.printf("%s выбрал роль %s\n", name, chosenRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (chosenRole != null) {
                out.printf("%s покидает дом и освобождает роль %s\n", name, chosenRole);
                house.removeRole(chosenRole);
                chosenRole = null;
                house.notifyAll();
            }
        }
    }
}
