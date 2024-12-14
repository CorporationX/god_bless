package school.faang.task326.GoT;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class House {
    private String name;
    private List<Role> roles;
    private int roleAmount;

    public synchronized void removeRole() {
        while (roleAmount == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " ждет освобождения роли");
                wait();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
        roleAmount--;
    }

    public synchronized void addRole(Role role) {
        roleAmount++;
        System.out.println("В доме " + name + " Освободилась роль " + role.name());
        notifyAll();
    }

    public boolean containsRole(Role role) {
        return roles.contains(role);
    }

}
