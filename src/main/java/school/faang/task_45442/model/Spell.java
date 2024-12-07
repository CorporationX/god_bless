package school.faang.task_45442.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum Spell {
    EXPECTO_PATRONUM("Creates a Patronus, a silvery guardian that protects against Dementors."),
    WINGARDIUM_LEVIOSA("Makes objects fly or levitate."),
    LUMOS("Illuminates the tip of the wand, providing light.");

    private final String description;
}