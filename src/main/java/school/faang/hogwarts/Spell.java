package school.faang.hogwarts;

import lombok.AllArgsConstructor;


public enum Spell {
    ALOHOMORA("Alohomora"), LUMOS("Lumos"), EXPELLIARMUS("Expelliarmus");
    private String spell;

    Spell(String spell) {
        this.spell = spell;
    }

    public String getSpell() {
        return spell;
    }

}
