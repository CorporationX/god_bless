package faang.school.BJS2_57346;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Spell {
    ALOHOMORA("Alohomora"),
    LUMOS("Lumos"),
    EXPELLIARMUS("Expelliarmus");

    private final String name;
}