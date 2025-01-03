package school.faang.bjs248887;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.Optional;

@RequiredArgsConstructor
public class User {
    private final String name;
    private Optional<String> role;
    private Optional<House> house;
    private final Object lock = new Object();

    @SneakyThrows
    public void joinHouse(House house) {
        synchronized (lock) {
            while (house.getRolesCounter() < 1) {
                System.out.printf("%s is in queue. %s has no free roles, "
                        + "waiting for other user to leave...\n", this.name, house.getName());
                house.wait();
            }

            this.house = Optional.of(house);
            this.role = Optional.ofNullable(house.getRoles().get(0));
            house.removeRole(this.role.get());
            System.out.printf("%s has entered the : %s, and took role of: %s\n",
                    this.name, house.getName(), this.role);
        }
    }

    public void leaveHouse() {
        synchronized (lock) {
            if (!this.house.isEmpty()) {
                System.out.printf("%s has left %s, notifying waiters about free role: %s\n",
                        this.name, house.get().getName(), this.role);
                house.get().addRole(this.role.get());
                this.role =  Optional.empty();
                house.notifyAll();
                this.house =  Optional.empty();
            }
        }
    }


}
