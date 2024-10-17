package school.BJS2_37070;

import java.util.List;
import java.util.Random;

public class House {

    private List<String> role;
    private int availableRole;

    public House(List<String> role) {
        this.role = role;
        availableRole = role.size();
    }

    public String addRole() throws InterruptedException {
        Random random = new Random();
        if (availableRole == 0) {
            wait();
        }
        availableRole--;
        return role.get(random.nextInt(role.size() - 1));
    }

    public void removeRole() {
        if (availableRole < role.size())
            availableRole++;
        notifyAll();
    }

    public int getAvailableRole() {
        return availableRole;
    }
}
