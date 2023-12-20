package faang.school.godbless.multi.task8iron_tron;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private int countRole;
    private final List<String> roles = new ArrayList<>();

    public House(int countRole) {
        this.countRole = countRole;
    }

    public synchronized void addRole(String role) {
        roles.add(role);
        countRole--;
        notifyAll();
    }

    public synchronized void removeRole(String role) {
        roles.remove(role);
        countRole++;
        notifyAll();
    }
}
