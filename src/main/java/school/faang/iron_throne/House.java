package school.faang.iron_throne;

import lombok.SneakyThrows;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class House {
    private final Map<String, Boolean> houses = new ConcurrentHashMap<>(Map.of("black", false, "red",
            false, "green", false));
    private final Object look = new Object();

    @SneakyThrows
    String assignRole(User user) {
        synchronized (look) {
            for (String house : houses.keySet()) {
                if (!houses.get(house)) {
                    houses.put(house, true);
                    return house;
                }
            }
            System.out.println(user.getName() + " придется подождать, нет свободной роли");
            look.wait(3000);
            for (String house : houses.keySet()) {
                if (!houses.get(house)) {
                    houses.put(house, true);
                    return house;
                }
            }
        }
        return ", ммм... перепутал, он остался без роли)";
    }

    void releaseRole(String role) {
        synchronized (look) {
            if (houses.containsKey(role)) {
                houses.put(role, false);
                System.out.println("Освободилась роль: " + role);
                look.notify();
            }
        }
    }
}
