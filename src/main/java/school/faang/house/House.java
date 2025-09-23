package school.faang.house;

import java.util.concurrent.locks.ReentrantLock;
import java.util.EnumMap;

public class House {
    private final EnumMap<Role, ReentrantLock> roleLocks = new EnumMap<>(Role.class);

    static {
        for (Role role : Role.values()) {
            roleLocks.put(role, new ReentrantLock());
        }
    }

    public void assignRole(String role) {
        ReentrantLock lock = roleLocks.get(role);
    }

}
