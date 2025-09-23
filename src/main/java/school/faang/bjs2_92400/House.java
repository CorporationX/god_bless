package school.faang.bjs2_92400;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class House {
    @Getter private String name;
    private List<String> availableRoles;

    public synchronized void assignRole(User user) throws InterruptedException {
        while (!availableRoles.contains(user.getAssignedRole())) {
            log.info("Пользователь {} ожидает освбождения роли {} ...", user.getName(), user.getAssignedRole());
            this.wait();
        }
        availableRoles.remove(user.getAssignedRole());
    }

    public synchronized void releaseRole(User user) {
        availableRoles.add(user.getAssignedRole());
        log.info("Пользователь {} освободил роль {}", user.getName(), user.getAssignedRole());
        this.notifyAll();
    }
}
