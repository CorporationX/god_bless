package school.faang.bjs282270;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @EqualsAndHashCode.Include
    @NonNull
    private String name;

    @ToString.Exclude
    private String assignedRole;

    @ToString.Exclude
    private House currentHouse;

    public void joinHouse(@NonNull House house) throws InterruptedException {
        String role = house.assignRole(this);
        this.assignedRole = role;
        this.currentHouse = house;
    }

    public void leaveHouse() {
        Optional.ofNullable(currentHouse)
                .ifPresent(house -> {
                    house.releaseRole(assignedRole, this);
                    this.assignedRole = null;
                    this.currentHouse = null;
                });
    }
}
