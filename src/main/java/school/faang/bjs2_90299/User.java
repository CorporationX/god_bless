package school.faang.bjs2_90299;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Getter
@RequiredArgsConstructor
public class User {
    private final String name;
    private Optional<Role> assignedRole;


    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = Optional.of(house.assignRole());

            log.info("{} got a role {} in the house", name, assignedRole.get());
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            if (assignedRole.isPresent()) {
                house.releaseRole(assignedRole.get());
            } else {
                throw new RuntimeException();
            }
            log.info(" {} left the house. left home. He had a role {}", name, assignedRole.get());
            assignedRole = Optional.empty();
        }
    }
}
