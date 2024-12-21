package school.faang.sprint_3.task_49075;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Data
public class House {
    private Queue<String> roles;
    private final Object lock = new Object();

    public House(List<String> roles) {
        this.roles = new LinkedList<>(roles);
    }

    public synchronized String addRole() {
        if (roles.isEmpty()) {
            System.out.println("Нет доступных ролей");
            return null;
        }
        return roles.poll();
    }

    public synchronized void removeRole(String role) {
        roles.offer(role);
        notifyAll();
    }
}
