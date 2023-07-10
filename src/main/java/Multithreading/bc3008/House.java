package Multithreading.bc3008;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class House {
    private List<String> roles;
    private int countFreeRole;


    public synchronized void addRole(String role) {
        roles.add(role);
        countFreeRole++;
        notifyAll();
    }

    public synchronized void removeRole(String role) {
        roles.remove(role);
        countFreeRole--;
    }
}
