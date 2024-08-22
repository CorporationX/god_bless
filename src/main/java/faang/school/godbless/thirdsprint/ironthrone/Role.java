package faang.school.godbless.thirdsprint.ironthrone;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    KNIGHT("Knight"),
    QUEEN("Queen"),
    MAGE("Mage"),
    LORD("Lord"),
    DRAGON_RIDER("Dragon Rider");

    private final String title;

    @Override
    public String toString() {
        return title;
    }
}
