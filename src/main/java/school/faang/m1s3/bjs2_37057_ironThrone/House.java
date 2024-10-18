package school.faang.m1s3.bjs2_37057_ironThrone;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class House {
    private final String name;
    private final Set<Role> availableRoles = new HashSet<>(List.of(Role.values()));

    public void removeAvailableRole(Role role) {
        availableRoles.remove(role);
    }

    public void addAvailableRole(User user) {
        availableRoles.add(user.getRole());
    }
}
