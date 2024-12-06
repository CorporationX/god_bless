package school.faang.task_bjs2_44585;

import lombok.ToString;

@ToString
public enum SpellType {
    EXPECTO_PATRONUM("Expecto Patronum", "A defensive charm that produces a Patronus."),
    WINGARDIUM_LEVIOSA("Wingardium Leviosa", "A charm used to levitate objects."),
    LUMOS("Lumos", "A charm that illuminates the tip of the wand.");

    private final String name;
    private final String description;

    SpellType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}