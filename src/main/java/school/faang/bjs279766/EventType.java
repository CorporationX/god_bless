package school.faang.bjs279766;

import lombok.Getter;

public enum EventType {
    PROTECTION("Protection"),
    ATTACK("Attack"),
    ENCHANTMENT("Enchantment");

    @Getter()
    private final String label;

    EventType(String label) {
        this.label = label;
    }
}