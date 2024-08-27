package faang.school.godbless.BJS2_24106;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class House {
    private Map<String, Boolean> availableRoles;
    private int countOfAvailableRoles;

    public synchronized void addRole(String role) {
        availableRoles.put(role, Boolean.FALSE);
        countOfAvailableRoles--;
        System.out.println("The role '" + role + "' was taken");
    }

    public synchronized void removeRole(String role) {
        availableRoles.put(role, Boolean.TRUE);
        countOfAvailableRoles++;
        System.out.println("The role '" + role + "' is free");
        notifyAll();
    }
}
