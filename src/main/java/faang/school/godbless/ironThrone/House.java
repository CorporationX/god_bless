package faang.school.godbless.ironThrone;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class House {
    public static final List<String> ROLES = List.of("1", "2", "3");

    @Getter
    private Map<String, Integer> availableRoles;//ключ - роль, значение - количество доступных ролей
    private Map<String, Object> locks;//ключ - роль, значение - лок для данной роли
    private final Random random;


    public House() {
        random = new Random();
        initAvailableRoles();
        initLocks();
    }

    private void initAvailableRoles() {
        availableRoles = new HashMap<>();
        for (String role : ROLES) {
            availableRoles.put(role, random.nextInt(1, 4));
        }
    }

    private void initLocks() {
        locks = new HashMap<>();
        for (String role : ROLES) {
            locks.put(role, new Object());
        }
    }

    public void joinUser(String role) {
        Object lock = locks.get(role);
        synchronized (lock) {
            while (availableRoles.get(role) == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            availableRoles.put(role, availableRoles.get(role) - 1);
        }
    }

    public void leaveUser(String role) {
        Object lock = locks.get(role);
        synchronized (lock) {
            availableRoles.put(role, availableRoles.get(role) + 1);
            lock.notifyAll();
        }
    }
}
