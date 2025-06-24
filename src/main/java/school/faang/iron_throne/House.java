package school.faang.iron_throne;

import java.util.HashMap;
import java.util.Map;

public class House {
    private final Map<String, Boolean> houses = new HashMap<>(Map.of("black", false, "red",
            false, "green", false));
    private final Object lock = new Object();

    String assignRole(User user) {
        synchronized (lock) {
            String result = freeRole();
            while (result == null) {
                System.out.println(user.getName() + " придется подождать, нет свободной роли");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                result = freeRole();
            }
            return result;
        }
    }

    public void releaseRole(String role) {
        synchronized (lock) {
            if (houses.containsKey(role)) {
                houses.put(role, false);
                System.out.println("Освободилась роль: " + role);
                lock.notifyAll();
            }
        }
    }

    private String freeRole() {
        for (String house : houses.keySet()) {
            if (!houses.get(house)) {
                houses.put(house, true);
                return house;
            }
        }
        return null;
    }
}