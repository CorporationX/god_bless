package school.faang.bjs282270;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Getter
@RequiredArgsConstructor
@ToString(exclude = {"assignedRole", "currentHouse"})
@EqualsAndHashCode(of = "name")
public class User {
    @NonNull
    private String name;
    private String assignedRole;
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