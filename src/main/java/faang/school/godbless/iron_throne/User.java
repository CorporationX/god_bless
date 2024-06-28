package faang.school.godbless.iron_throne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@RequiredArgsConstructor
public class User {
    private Role role;
    private final House house;

    public void joinHouse() {
        house.addRole(this);
    }

    public void leaveHouse() {
        house.removeRole(role);
    }

    public Role chooseRole(Set<Role> roleSet) {
        List<Role> roleList = roleSet.stream().toList();

        int randomRoleIndex = ThreadLocalRandom.current().nextInt(roleList.size());

        return roleList.get(randomRoleIndex);
    }
}
