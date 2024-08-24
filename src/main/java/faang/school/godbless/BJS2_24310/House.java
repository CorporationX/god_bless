package faang.school.godbless.BJS2_24310;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class House {
    private final Object lock = this;
    private int freeRoles;
    private List<Role> roles;

    public void addRole() {
        synchronized (lock) {
            freeRoles--;
            lock.notifyAll();
        }
    }

    public void removeRole(User user) {
        synchronized (lock) {
            freeRoles++;
            System.out.println(user.getName() + " leave house");
            lock.notifyAll();
        }
    }
}
