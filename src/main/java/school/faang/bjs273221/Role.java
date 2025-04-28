package school.faang.bjs273221;

import lombok.Getter;

@Getter
public enum Role {
    WARRIOR("Warrior"),
    LORD("Lord"),
    MAGE("Mage");

    private final String title;

    Role(String title) {
        this.title = title;
    }
}
