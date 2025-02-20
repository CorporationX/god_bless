package bjs261468;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    MAGE("Mage"),
    LORD("Lord"),
    TRADER("Trader"),
    WARRIOR("Warrior"),
    DOCTOR("Doctor"),
    ARCHITECT("Architect"),
    CHEMIST("Chemist"),
    BUFFOON("Buffon"),
    CLEANER("Cleaner"),
    DEFAULT_WITHOUT_ROLE("Default");

    private final String text;
}
