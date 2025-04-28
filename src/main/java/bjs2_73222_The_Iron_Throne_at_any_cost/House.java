package bjs2_73222_The_Iron_Throne_at_any_cost;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private final List<String> roles = new ArrayList<>();

    public House(List<String> roles) {
        this.roles.addAll(roles);
    }

    public synchronized String assignRole() {
        while (roles.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                log.info("couldn't assign a role");
                Thread.currentThread().interrupt();
                throw new IllegalStateException("the method was interrupted");
            }
        }
        return roles.remove(0);
    }

    public synchronized void releaseRole(String role) {
            roles.add(role);
            notifyAll();
    }
}
