package school.faang.bjs248887;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class User {
    private final String name;
    private String role;
    private House house;

    @SneakyThrows
    public void joinHouse(House house) {
        synchronized (house) {
            while (house.getRolesCounter() < 1) {
                System.out.printf("%s is in queue. %s has no free roles, "
                        + "waiting for other user to leave...\n", this.name, house.getName());
                house.wait();
            }

            this.house = house;
            this.role = house.getRoles().get(0);
            house.removeRole(this.role);
            System.out.printf("%s has entered the : %s, and took role of: %s\n",
                    this.name, house.getName(), this.role);
        }
    }

    public synchronized void leaveHouse() {
        synchronized (house) {
            if (this.house != null) {
                System.out.printf("%s has left %s, notifying waiters about free role: %s\n",
                        this.name, house.getName(), this.role);
                house.addRole(this.role);
                this.role = null;
                house.notifyAll();
                this.house = null;
            }
        }
    }


}
