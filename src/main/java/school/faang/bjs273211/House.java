package school.faang.bjs273211;

import java.util.ArrayList;
import java.util.List;

public class House {
    private final List<Role> roles;

    public House(List<Role> roles) {
        this.roles = new ArrayList<>(roles);
    }

    public synchronized Role assignRole() {
        while (roles.isEmpty()) {
            try {
                System.out.println(Thread.currentThread().getName() + " ждёт освобождения роли");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        Role assigned = roles.remove(0);
        System.out.println(Thread.currentThread().getName() + " получил роль " + assigned);
        return assigned;
    }

    public synchronized void releaseRole(Role role) {
        roles.add(role);
        System.out.println(Thread.currentThread().getName() + " освободил роль " + role);
        notifyAll();
    }
}

