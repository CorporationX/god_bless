package faang.school.godbless.iron_throne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class House {
    private final String houseName;
    private final Set<Role> allRoles = Set.of(Role.values());
    private final Set<Role> currentRoles = new HashSet<>();

    public synchronized void addRole(User user) {
        while (!isHouseAvailableToJoin()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Set<Role> availableRoles = getAvailableRoles();
        Role role = user.chooseRole(availableRoles);
        user.setRole(role);

        currentRoles.add(role);
        System.out.println(role + " JOINED to " + houseName);
    }

    public synchronized void removeRole(Role role) {
        currentRoles.remove(role);
        notifyAll();
        System.out.println(role + " LEFT to " + houseName);
    }

    public boolean isHouseAvailableToJoin() {
        return allRoles.size() != currentRoles.size();
    }

    private Set<Role> getAvailableRoles() {
        Set<Role> copyOfAllRoles = new HashSet<>(allRoles);
        copyOfAllRoles.removeAll(currentRoles);
        return copyOfAllRoles;
    }
}
