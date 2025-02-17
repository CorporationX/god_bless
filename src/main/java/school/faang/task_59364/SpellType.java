package school.faang.task_59364;

import lombok.Getter;


@Getter
public enum SpellType {
    ALOHOMORA("Alohomora"),
    LUMOS("Lumos"),
    EXPELLIARMUS("Expelliarmus");

    private final String spellName;

    SpellType(String spellName) {
        this.spellName = spellName;
    }
}
