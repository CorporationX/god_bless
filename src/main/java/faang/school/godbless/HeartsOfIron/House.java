package faang.school.godbless.HeartsOfIron;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {
    private List<String> availableRoles = new ArrayList<>();

    public House() {
        availableRoles.add("kunkka");
        availableRoles.add("pudge");
        availableRoles.add("invoker");
        availableRoles.add("witch doctor");
        availableRoles.add("omniknight");
    }

    public synchronized void addRole(String role) {
        availableRoles.add(role);
        notify();
    }

    public synchronized String removeRole() {
        int randomRole = new Random().nextInt(getAvailableRoles().size());
        while (getAvailableRoles().isEmpty()) {
            try {
                System.out.println("нету ролей. терпим пока освободится");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return getAvailableRoles().remove(randomRole);
    }
}
