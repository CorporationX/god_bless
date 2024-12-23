package school.faang.task_48905;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {

    private final String name;
    private House house;
    private Role role;

    public User(String name) {
        if (name == null || name.isEmpty()) {
            log.error("Name cannot be null or empty");
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            while (house.getNumberOfAvailableRoles() == 0) {
                log.info(" {} ждет, пока освободится роль", name);
                house.wait();
            }
            Role role = house.removeRole();
            this.house = house;
            this.role = role;
            log.info("{} выбрал роль: {}", name, role);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            log.info("{} покидает дом и освобождает роль: {} ", name, role);
            house.addRole(role);
            house.notifyAll();
            this.house = null;
            this.role = null;
        }
    }
}