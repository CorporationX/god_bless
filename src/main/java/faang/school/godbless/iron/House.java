package faang.school.godbless.iron;

import lombok.Getter;

import java.util.Map;

@Getter
public class House {
    private Map<String, Integer> rolesWithQuantity;

    public House(Map<String, Integer> rolesWithQuantity) {
        if (rolesWithQuantity.isEmpty() || rolesWithQuantity == null) {
            throw new IllegalArgumentException(
                    "An empty or non-existent Map was received in the constructor of the House class");
        }
        this.rolesWithQuantity = rolesWithQuantity;
    }
}
