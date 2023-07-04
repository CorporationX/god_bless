package faang.school.godbless.synchronizationWaitNotify.ironThrone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@AllArgsConstructor
public class User {
    @Setter
    private String name;
    private final House house;
    private RoleUser role;

    private final Random random = new Random();

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse() {
        synchronized (house) {
            if (house.getAvailableRoles().size() == 0) {
                try {
                    System.out.printf("Поток: %s. игрок %s присоединяется к дому и ожидает получения роли.\n",
                            Thread.currentThread().getName(), name);
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            List<RoleUser> roleUserList = house.getAvailableRoles();
            this.role = roleUserList.get(random.nextInt(roleUserList.size()));

            house.addRole(role);
            System.out.printf("Поток: %s. игрок %s присоединился к дому с ролью %s.\n",
                    Thread.currentThread().getName(), this.name, this.role);

        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (role == null) {
                System.out.println("игрок " + name + " уже покинул дом!");
                return;
            }

            house.removeRole(role);
            this.role = null;
            System.out.printf("Поток: %s. игрок %s покидает дом.\n",
                    Thread.currentThread().getName(), name);
        }
    }
}
