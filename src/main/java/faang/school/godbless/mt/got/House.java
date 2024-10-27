package faang.school.godbless.mt.got;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private final List<String> roles;
    private int rolesCounts;
    @Getter
    private String name;

    public House(String name, List<String> roles) {
        this.name = name;
        this.roles = new ArrayList<>(roles);
        this.rolesCounts = roles.size();
    }

    public synchronized String addRole() throws InterruptedException {
        while (rolesCounts <= 0) {
            log.info("Ожидание освобождения роли в доме '{}'", name);
            this.wait();
        }
        String role = roles.get(rolesCounts - 1);
        rolesCounts--;
        log.info("Роль '{}' занята в доме '{}'", role, name);
        return role;
    }

    public synchronized void removeRole() {
        rolesCounts++;
        log.info("Роль освободилась в доме '{}'", name);
        this.notifyAll();
    }
}
