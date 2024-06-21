package faang.school.godbless.iron_throne_at_any_cost;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class House {
    private Map<Role, Integer> availableRoles;
}
