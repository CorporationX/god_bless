package faang.school.godbless.ironThrone;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Getter
public class House {
    private static final List<String> ROLES = List.of("1", "2", "3");

    private Map<String, Integer> availableRoles;//ключ - роль, значение - количество доступных ролей

    public House() {
        availableRoles = new HashMap<>();
        Random random = new Random();

        for (String role : ROLES) {
            availableRoles.put(role, random.nextInt(1, 4));
        }
    }

    public static List<String> getRoles() {
        return ROLES;
    }


    public void joinUser(String role) {
        Integer lock;
        synchronized (lock = availableRoles.get(role)) {
            if (availableRoles.get(role) == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            availableRoles.put(role, availableRoles.get(role) - 1);//!!!!!!!!!!проверить, что значение лока меняется
            // вместе с оригиналом, на который он указывает, иначе капут
        }
    }

    public void leaveUser(String role) {
        Integer lock;
        synchronized (lock = availableRoles.get(role)) {
            availableRoles.put(role, lock + 1);
            lock.notify();
        }
    }
}
