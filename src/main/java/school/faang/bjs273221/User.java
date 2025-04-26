package school.faang.bjs273221;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
@Setter
public class User {
    private final String name;
    private String assignedRole;

    public void joinHouse(House house) {
        try {
            house.assignRole(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted {}", e.getMessage());
        }
    }

    public void leaveHouse(House house) {
        house.releaseRole(this);
    }
}
