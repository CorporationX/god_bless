package faang.school.godbless.theIronThrone;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class House {
    private final String name;
    private final List<String> emptyRoles;
    private int amountOfEmptyRoles;

    public House(String name) {
        this.name = name;
        this.emptyRoles = new ArrayList<>();
        this.amountOfEmptyRoles = 0;
    }

    public boolean checkForEmptyRole() {
        return amountOfEmptyRoles > 0;
    }

    public synchronized void addRole(String role) {
            emptyRoles.add(role);
            amountOfEmptyRoles++;
            notifyAll();
    }

    public synchronized void removeRole(String role) {
            emptyRoles.remove(role);
            amountOfEmptyRoles--;
            notifyAll();
    }

}
