package school.faang.thirdStream.BJS2_37074;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@RequiredArgsConstructor
@Getter
public class House {
    private final String name;
    private final Set<Role> availableRoles = new ConcurrentSkipListSet<>(List.of(Role.values()));

    public void removeRole(Role role) {
        availableRoles.remove(role);
    }

    public void addAvailableRole(User user) {
        availableRoles.add(user.getRole());
    }
}
