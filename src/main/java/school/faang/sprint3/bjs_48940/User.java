package school.faang.sprint3.bjs_48940;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Slf4j
public class User {
    private static final Random RANDOM = new Random();

    private final String name;
    private final House house;
    @Setter
    private String role;

    public synchronized void joinHouse() throws InterruptedException {
        synchronized (house) {
            while (house.getAvailableRolesAmount() == 0) {
                log.info("{} ждет освобождения роли...", name);
                house.wait();
            }
            this.role = addRole();
            log.info("Пользователь {} выбрал роль: {}", name, role);
            log.info("Количество доступных ролей: {}", house.getAvailableRolesAmount());
        }
    }

    public synchronized void leaveHouse() throws InterruptedException {
        synchronized (house) {
            log.info("Пользователь {} освободил роль: {}", name, role);
            removeRole();
            house.notifyAll();
        }
    }

    private String addRole() {
        house.setAvailableRolesAmount(house.getAvailableRolesAmount() - 1);
        List<String> roles = house.getRoles();
        int randomRoleIndex = RANDOM.nextInt(roles.size());
        String chosenRole = roles.get(randomRoleIndex);
        roles.remove(randomRoleIndex);

        return chosenRole;
    }

    private void removeRole() {
        house.setAvailableRolesAmount(house.getAvailableRolesAmount() + 1);
        List<String> roles = house.getRoles();
        roles.add(role);
    }
}
