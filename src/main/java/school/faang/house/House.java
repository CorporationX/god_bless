package school.faang.house;

import java.util.EnumMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class House {
    private String nameHouse;
    private final EnumMap<Role, Semaphore> roleLocks;

    public House(String name) {
        this.nameHouse = name;
        roleLocks = new EnumMap<>(Role.class);
        for (Role role : Role.values()) {
            roleLocks.put(role, new Semaphore(role.getMaxMembers(), true));
        }
    }

    public void assignRole(User user, Role role) {
        System.out.println(String.format("%s пытается получить роль %s", user.getName(), role));
        if (role == null) {
            throw new IllegalArgumentException("Role must not be null");
        }
        Semaphore semaphore = roleLocks.get(role);
        if (semaphore == null) {
            throw new IllegalStateException("No semaphore for role: " + role);
        }
        semaphore.acquireUninterruptibly();
        System.out.printf("%s вошел в %s%n", user.getName(), nameHouse);
        user.setRole(role);
    }


    public void releaseRole(User user) {
        Role role = user.getRole();
        if (role != null) {
            Semaphore semaphore = roleLocks.get(role);
            semaphore.release();
            System.out.printf("%s покинул роль %s%n", user.getName(), role);
            user.setRole(null);
        }
    }

}
