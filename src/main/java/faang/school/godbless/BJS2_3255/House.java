package faang.school.godbless.BJS2_3255;

import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class House {
    @NonNull
    private String name;
    private final Map<String, User> roles = new HashMap<>();
    private Integer totalRoles = 0;
    private Integer currentRoles = 0;

    public void addRole(String role) {
        synchronized (roles) {
            if (roles.containsKey(role)) {
                throw new IllegalArgumentException();
            }
            roles.put(role, null);
            totalRoles++;
            System.out.println("House " + name + " add role " + role);
            roles.notifyAll();
        }
    }

    @SneakyThrows
    public void removeRole(String role) {
        synchronized (roles) {
            // Я не нашел информацию как обрабатывать notifyAll на стороне consumer
            // поэтому сделал как первое в голову пришло
            while (Objects.equals(currentRoles, totalRoles)) {
                roles.wait();
            }
            if (!roles.containsKey(role)) {
                throw new IllegalArgumentException();
            }
            if (roles.get(role) != null) {
                throw new IllegalArgumentException();
            }
            roles.remove(role);
            System.out.println("House " + name + " remove role " + role);
            totalRoles--;
        }
    }

    @SneakyThrows
    public void addUser(User user) {
        synchronized (roles) {
            while (Objects.equals(currentRoles, totalRoles)) {
                roles.wait();
            }
            for (var entry : roles.entrySet()) {
                if (entry.getValue() == null) {
                    user.setHouse(this);
                    user.setRole(entry.getKey());
                    roles.put(entry.getKey(), user);
                    currentRoles++;
                    System.out.println("House " + name + " add user " + user.getName() + " on role " + entry.getKey());
                    break;
                }
            }
        }
    }

    @SneakyThrows
    public void removeUser(User user) {
        synchronized (roles) {
            roles.put(user.getRole(), null);
            System.out.println("House " + name + " remove user " + user.getName() + " from role " + user.getRole());
            user.setHouse(null);
            user.setRole(null);
            currentRoles--;
            roles.notifyAll();
        }
    }

    public User getUser(String role) {
        return roles.get(role);
    }
}
