package school.faang.thirdStream.BJS2_37074;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
public class User {
    private final String name;
    private House house;
    private Role role;

    public void joinHouse(House house, Role role) {
        synchronized (house.getAvailableRoles()) {
            while (!house.getAvailableRoles().contains(role)) {
                System.out.println("Подождите пока освободится роль в доме.");
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    System.out.println("Процесс ождания прерван");
                    e.printStackTrace();
                }
            }
            this.house = house;
            this.role = role;
            house.removeRole(role);
            System.out.printf("%s выбрал роль %s дома %s%n", name, role, house.getName());
        }
    }

    public synchronized void leaveHouse() {
        if (Objects.isNull(this.house) || Objects.isNull(this.role)) {
            throw new IllegalArgumentException("Вы еще не вступили ни в какой дом");
        }

        synchronized (house.getAvailableRoles()) {
            System.out.printf("%s %s покидает дом %s%n", role, name, house.getName());
            house.addAvailableRole(this);
            house.getAvailableRoles().notifyAll();
            this.role = null;
            this.house = null;
        }
    }
}
