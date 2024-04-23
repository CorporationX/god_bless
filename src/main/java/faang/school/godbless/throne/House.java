package faang.school.godbless.throne;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class House {
    private List<String> availableRoles;
    private int numAvailableRoles;

    public House() {
        this.availableRoles = new ArrayList<>();
        this.numAvailableRoles = 0;
    }

    public synchronized void addRole(String role) {
        while (numAvailableRoles >= 5) {
            try {
                System.out.println("Достигнуто максимальное количество ролей в " + this + " | Ожидание...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        availableRoles.add(role);
        numAvailableRoles++;
        notifyAll();
    }

    public synchronized void removeRole(String role) {
        availableRoles.remove(role);
        numAvailableRoles--;
        notifyAll();
    }
}