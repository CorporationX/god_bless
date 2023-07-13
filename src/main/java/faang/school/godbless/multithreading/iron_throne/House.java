package faang.school.godbless.multithreading.iron_throne;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class House {

    private List<String> roles;
    private AtomicInteger availableRolesCount;

    public void addRole() {
        availableRolesCount.decrementAndGet();
    }

    public void removeRole() {
        availableRolesCount.incrementAndGet();
    }
}
