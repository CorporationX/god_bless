package school.faang.spellmanagement;


import lombok.Getter;

@Getter
public enum Spell {
    LUMOS("Lumos", "The light appears!"),
    EXPELLIARMUS("Expelliarmus", "The enemy is disarmed!"),
    WINGARDIUM_LEVIOSA("Wingardium Leviosa", "The object rises into the air!"),
    EXPECTRO_PATRONUM("Expecto Patronum", "The patronus appears for protection!");

    private final String name;
    private final String description;

    Spell(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
