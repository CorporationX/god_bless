package school.faang.bjs249099;

import lombok.Getter;

import java.util.List;

@Getter
public class House {

    private String name;
    private List<String> roles;
    private int availableRoleCount;

    public House(String name, List<String> roles) {
        this.name = name;
        this.roles = roles;
        availableRoleCount = roles.size();
    }

    public synchronized void addRole() {
        availableRoleCount++;
        notifyAll();
    }

    public synchronized void removeRole() {
        availableRoleCount--;
    }

}
