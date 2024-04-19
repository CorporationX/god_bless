package faang.school.godbless.iron_throne;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class House {
    private String name;
    private Map<HouseRole, Integer> rolesMap;

    public synchronized void addRole(HouseRole houseRole) {
        rolesMap.computeIfPresent(houseRole, (k, v) -> v - 1);
    }

    public void removeRole(HouseRole houseRole) {
        rolesMap.computeIfPresent(houseRole, (k, v) -> v + 1);
        notify();
    }
}