package school.faang.bjs2_90550;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<String> roles = new ArrayList<>();

    public House() {
        roles.add("Lord");
        roles.add("Knight");
        roles.add("Mage");
    }


    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.printf("Thread %s was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        String returnedRole = roles.get(0);
        roles.remove(0);
        return returnedRole;
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        notifyAll();
    }
}
