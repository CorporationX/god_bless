package school.faang.bjs273211;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<String> roles;

    public House(List<String> roles) {
        this.roles = new ArrayList<>(roles);
    }

    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                System.out.println(Thread.currentThread().getName() + " ждёт освобождения роли");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        String assigned = roles.remove(0);
        System.out.println(Thread.currentThread().getName() + " получил роль " + assigned);
        return assigned;
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        System.out.println(Thread.currentThread().getName() + " освободил роль " + role);
        notifyAll();
    }
}

