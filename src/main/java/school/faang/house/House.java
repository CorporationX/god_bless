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
    private String name;
    private final EnumMap<Role, Semaphore> roleLocks;

    public House(String name, Map<Role, Integer> maxSlotsPerRole) {
        this.name = name;
        roleLocks = new EnumMap<>(Role.class);
        for (Role role : Role.values()) {
            int maxSlots = maxSlotsPerRole.getOrDefault(role, 1);
            roleLocks.put(role, new Semaphore(maxSlots, true));
        }
    }

    public void assignRole(User user, Role role) {
        System.out.println(String.format("%s пытается получить роль %s", user.getName(), role));
        Semaphore semaphore = roleLocks.get(role);
        semaphore.acquireUninterruptibly();
        System.out.println("%s вошел в %s", user.getName(), name);
        user.setAssignedRole(role);
    }

    public void releaseRole(User user) {
        Role role = user.getAssignedRole();
        if (role != null) {
            Semaphore semaphore = roleLocks.get(role);
            semaphore.release();
            System.out.println("%s покинул роль %s", user.getName(), role);
            user.setAssignedRole(null);
        }
    }

}
